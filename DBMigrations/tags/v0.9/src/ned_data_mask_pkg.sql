CREATE OR REPLACE PACKAGE BODY ned_data_mask_pkg AS
  Version VARCHAR2(42) := '1.0.0';
  CustomErrorCode CONSTANT BINARY_INTEGER := -20000;
  Lf CONSTANT CHAR(1) := chr(10);

  DigitDomain CONSTANT VARCHAR(2) := '\d';

  PROCEDURE debug(msg CLOB)
    /**
    * Outputs a time-stamped message. Supports CLOBs.
    */
  IS
    offset NUMBER := 1;
    MaxLineLength CONSTANT BINARY_INTEGER := 32767;
  BEGIN
    LOOP
      IF offset = 1 THEN
        dbms_output.put(to_char(SYSTIMESTAMP, '[YYYY-MM-DD HH24:MI:SS.FF1 TZR] ')) ;
      END IF;

      IF msg IS NULL OR offset > dbms_lob.getlength(msg) THEN
        IF offset = 1 THEN
          dbms_output.put_line(''); -- PUT() has to be "closed" by PUT_LINE()
        END IF;
        EXIT;
      END IF;

      dbms_output.put_line(dbms_lob.substr(msg, MaxLineLength, offset));
      offset := offset + MaxLineLength;
    END LOOP;
  END;

  FUNCTION split(s VARCHAR2, delimiter VARCHAR2 := ',', trimItems BOOLEAN := TRUE) RETURN STRING_LIST
    /**
     * Splits delimited string into string_tab TABLE
     * * Returns NULL if s is NULL (or '')
     */
  IS
    result STRING_LIST := STRING_LIST() ;
    currIndex BINARY_INTEGER := 1;
    nextIndex BINARY_INTEGER;
    i NUMBER := 1;
  BEGIN
    IF s IS NULL THEN
      RETURN NULL;
    END IF;

    LOOP
      nextIndex := instr(s, delimiter, currIndex);
      result.extend;
      IF nextIndex > 0 THEN
        result(i) := substr(s, currIndex, nextIndex - currIndex);
      ELSE
        result(i) := substr(s, currIndex);
      END IF;
      IF trimItems THEN
        result(i) := trim(result(i));
      END IF;
      EXIT WHEN nextIndex = 0;
      i := i + 1;
      currIndex := nextIndex + 1;
    END LOOP;
    RETURN result;
  END;

  FUNCTION random_int(inclusive_min BINARY_INTEGER, inclusive_max BINARY_INTEGER) RETURN BINARY_INTEGER
    /**
    * Generates random numeric in the inclusive_min..inclusive_max range
    */
  IS
  BEGIN
    RETURN trunc(dbms_random.value(inclusive_min, inclusive_max + 1));
  END;

  FUNCTION effective_pattern(pattern VARCHAR2) RETURN VARCHAR2
  IS
    IncludedFormatRE CONSTANT VARCHAR(42) := '<.+?>';

    result VARCHAR2(32767) := pattern;
    includedFormat  VARCHAR2(130);-- ned_masked_data_formats.format_name%TYPE + 2
    includedPattern ned_masked_data_formats.pattern%TYPE;
  BEGIN
    LOOP
      includedFormat := regexp_substr(result, IncludedFormatRE);
      IF includedFormat IS NULL THEN
        RETURN result;
      END IF;
      SELECT pattern
      INTO includedPattern
      FROM ned_masked_data_formats
      WHERE format_name = substr(includedFormat, 2, length(includedFormat) - 2);
      result := replace(result, includedFormat, includedPattern);
    END LOOP;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      raise_application_error(CustomErrorCode, utl_lms.format_message(
          'Undefined format name `%s` found in `%s` during the processing of the `%s` pattern',
          includedFormat, result, pattern));
  END;

  FUNCTION generate_random_data(pattern VARCHAR2, null_percentage NUMBER := 0) RETURN VARCHAR2
    /**
    * Generates random value according to the supplied data masking pattern (see docs) and null_percentage
    */
  IS
    RandomValueDomainRE CONSTANT VARCHAR(42) := '\{.+?\}|\[.+?\]';
    CaseConversionRE CONSTANT VARCHAR(42) := '@upper|@lower|@proper';

    RangeDateFormat CONSTANT VARCHAR(42) := 'mm/dd/yyyy';
    ISODateFormat CONSTANT VARCHAR(42) := 'YYYY-MM-DD';

    result VARCHAR2(32767) := pattern;
    domainPattern VARCHAR2(32767);
    domain VARCHAR2(32767);
    caseConversion VARCHAR(42);
    isRangeDomain BOOLEAN;
    randomValue VARCHAR2(32767);
    pos BINARY_INTEGER;

    FUNCTION generate_range_domain_value(domain VARCHAR2) RETURN VARCHAR2
    IS
      RepetitionRE CONSTANT VARCHAR(42) := '\*\d+(-\d+)?$';
      NaturalNumberRE CONSTANT VARCHAR(42) := '^\d+$';
      DateRE CONSTANT VARCHAR(42) := '^\d\d/\d\d/\d\d\d\d$';

      LowerCaseDomain CONSTANT VARCHAR(2) := '\l';
      UpperCaseDomain CONSTANT VARCHAR(2) := '\u';

      -- String dates format with four-digit years that could be implicitly converted to dates
      ImplicitlyConvertibleDateFormat CONSTANT VARCHAR(11) := 'DD-MON-YYYY';

      result VARCHAR2(32767) := '';
      repetition VARCHAR2(42) := regexp_substr(domain, RepetitionRE);
      repetitionRange STRING_LIST;
      loops BINARY_INTEGER;
      singleDomain VARCHAR2(32767);
      domainToken VARCHAR2(32767);
      list STRING_LIST;
      rangeIndex NUMBER;
      range STRING_LIST;
      lowBoundaryDate DATE;
      highBoundaryDate DATE;
    BEGIN
      IF repetition IS NULL THEN
        loops := 1;
        singleDomain := domain;
      ELSE
        repetitionRange := split(substr(repetition, 2), '-');
        IF repetitionRange.count > 1 THEN
          -- Random number of loops
--           debug(utl_lms.format_message('#..# loops [%s..%s]', repetitionRange(1), repetitionRange(2)));
          loops := random_int(repetitionRange(1), repetitionRange(2));
        ELSE
--           debug(utl_lms.format_message('%s loops', repetitionRange(1)));
          -- Fixed number of loops
          loops := repetitionRange(1);
        END IF;
        singleDomain := replace(domain, repetition);
      END IF;

      -- noinspection SqlUnused
      FOR i IN 1..loops LOOP
        domainToken := singleDomain;
        list := split(domainToken, trimItems => FALSE);
        IF list.count > 1 THEN
--           debug('#..# a list item');
          domainToken := list(random_int(list.first, list.last));
        END IF;

        rangeIndex := instr(domainToken, '-');
        IF rangeIndex > 0 THEN
          range := split(domainToken, '-');
          IF regexp_instr(range(1), NaturalNumberRE) > 0 AND regexp_instr(range(1), NaturalNumberRE) > 0 THEN
--             debug(utl_lms.format_message('#..# a value from the natural number range [%s..%s]', range(1), range(2)));
            result := result || random_int(range(1), range(2));
            CONTINUE;
          END IF;

          IF regexp_instr(range(1), DateRE) > 0 AND regexp_instr(range(1), DateRE) > 0 THEN
            lowBoundaryDate := to_date(range(1), RangeDateFormat);
            highBoundaryDate := to_date(range(2), RangeDateFormat);
            /*debug(utl_lms.format_message('#..# a value from the date range [%s..%s]',
                                         to_char(lowBoundaryDate, ISODateFormat),
                                         to_char(highBoundaryDate, ISODateFormat)));*/
            result := result || to_char(lowBoundaryDate + random_int(0, highBoundaryDate - lowBoundaryDate),
                                        ImplicitlyConvertibleDateFormat);
            CONTINUE;
          END IF;
        END IF;

        CASE domainToken
          WHEN DigitDomain THEN
--             debug('#..# a digit');
            result := result || random_int(0, 9);
          WHEN LowerCaseDomain THEN
--             debug('#..# a lower-case letter');
            result := result || dbms_random.string('l', 1);
          WHEN UpperCaseDomain THEN
--             debug('#..# an upper-case letter');
            result := result || dbms_random.string('U', 1);
          ELSE
            result := result || domainToken;
        END CASE;
      END LOOP;
      RETURN result;
    END;

    FUNCTION generate_dict_domain_value(domain VARCHAR2) RETURN VARCHAR2
    IS
      result ned_masked_data_dict.value%TYPE;
    BEGIN
--       debug(utl_lms.format_message('#..# a value from the %s dictionary', domain));
      SELECT value
      INTO result
      FROM ned_masked_data_dict
      WHERE domain_name = domain
      OFFSET
        (SELECT ned_data_mask_pkg.random_int(0, count(1) - 1) AS random_offset
         FROM ned_masked_data_dict nmdd
         WHERE domain_name = domain) ROWS
      FETCH NEXT 1 ROW ONLY;
      RETURN result;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN -- NO_DATA_FOUND must be handled lest it is swallowed
        raise_application_error(CustomErrorCode, utl_lms.format_message(
            'Could not retrieve a random value from the dictionary domain `%s`.' || Lf ||
            'HINT: check ned_masked_data_dict.domain_name',
            domain));
    END;

  BEGIN
    -- NULL generation
    IF null_percentage > 0 AND dbms_random.value()*100 <= null_percentage THEN
      RETURN NULL;
    END IF;

    LOOP
      domainPattern := regexp_substr(result, RandomValueDomainRE);
      IF domainPattern IS NULL THEN
        RETURN result;
      END IF;
      isRangeDomain := (substr(domainPattern, 1, 1) = '{');
      caseConversion := regexp_substr(domainPattern, CaseConversionRE);
      -- Extract domain expression without a case conversion suffix if any
      domain := replace(substr(domainPattern, 2, length(domainPattern) - 2), caseConversion);
      randomValue := CASE
                     WHEN isRangeDomain THEN generate_range_domain_value(domain)
                     ELSE generate_dict_domain_value(domain) END;
      CASE caseConversion
        WHEN '@upper' THEN randomValue := upper(randomValue);
        WHEN '@lower' THEN randomValue := lower(randomValue);
        WHEN '@proper' THEN randomValue := initcap(randomValue);
        ELSE NULL;
      END CASE;

      -- Replace only the first occurrence of domainPattern with the generated random value
      -- Repeating patterns (e.g. {\d*3}) should be generated separately
      pos := instr(result, domainPattern);
      result := substr(result, 1, pos - 1) || randomValue || substr(result, pos + length(domainPattern));
    END LOOP;
  END;

  PROCEDURE mask_data(schemas VARCHAR2)
    /**
    * Masks data in schemas (comma-separated) according to the metadata from `ned_masked_data`
    */
  IS
    DefaultNullPercentage CONSTANT NUMBER := 10;
    DefaultCharMaskingDomain CONSTANT VARCHAR(7) := '\l, ,\u';
    DefaultDateMaskingDomain CONSTANT VARCHAR(21) := '01/01/1990-12/31/1999';
    AllNullsPercentage CONSTANT BINARY_INTEGER := 100;

    schemaList STRING_LIST := split(upper(schemas));
    effectivePattern VARCHAR2(32767);
    effectiveNullPercentage NUMBER(4, 1);
    updateSql CLOB;
  BEGIN
    debug(utl_lms.format_message('## NED Data Masking v%s ##%sProcessing schema(s) `%s`', Version, Lf, schemas));

    FOR maskedColumn IN (
      -- Encrypted columns + ned_masked_data_columns
      SELECT owner, table_name, column_name, tc.data_type, tc.data_length, tc.nullable
      FROM
        (SELECT ec.owner, ec.table_name, ec.column_name
         FROM all_encrypted_columns ec
         UNION --
         SELECT owner, table_name, column_name
         FROM ned_masked_data) sq
        JOIN all_tab_columns tc USING (owner, table_name, column_name)
      WHERE owner IN (SELECT * FROM TABLE(schemaList))
      ORDER BY owner, table_name, column_name
    ) LOOP
      debug(utl_lms.format_message('Processing %s.%s.%s', maskedColumn.owner, maskedColumn.table_name,
                                   maskedColumn.column_name));
      EXECUTE IMMEDIATE utl_lms.format_message('ALTER TABLE %s.%s DISABLE ALL TRIGGERS',
                                               maskedColumn.owner, maskedColumn.table_name);
      FOR rowSet IN (
        SELECT nmd.row_set_num, nmd.row_filter_sql, nmd.null_percentage, nmdf.pattern
        FROM ned_masked_data nmd
        LEFT JOIN ned_masked_data_formats nmdf USING (format_name)
        WHERE (nmd.owner, nmd.table_name, nmd.column_name) IN
                ((maskedColumn.owner, maskedColumn.table_name, maskedColumn.column_name))
        UNION ALL
        SELECT 1, NULL, DefaultNullPercentage,
               '{' || CASE
                 WHEN instr(maskedColumn.data_type, 'VARCHAR') > 0
                         THEN DefaultCharMaskingDomain || '*1-' || maskedColumn.data_length
                 WHEN maskedColumn.data_type IN ('CHAR', 'NCHAR')
                         THEN DefaultCharMaskingDomain || '*' || maskedColumn.data_length
                 WHEN maskedColumn.data_type = 'DATE'
                         THEN DefaultDateMaskingDomain
                 WHEN maskedColumn.data_type = 'NUMBER'
                         THEN DigitDomain || '*1-' || maskedColumn.data_length
               END || '}'
        FROM dual
        WHERE NOT EXISTS(
          SELECT 1
          FROM ned_masked_data
          WHERE (owner, table_name, column_name) IN
                  ((maskedColumn.owner, maskedColumn.table_name, maskedColumn.column_name))
        )
        ORDER BY row_set_num
      ) LOOP
        IF rowSet.pattern IS NULL AND rowSet.null_percentage < AllNullsPercentage THEN
          raise_application_error(CustomErrorCode, utl_lms.format_message(
            'Undefined default masking format for the type %s', maskedColumn.data_type));
        END IF;
        debug(utl_lms.format_message('Row set #%s: %s%s%s', to_char(rowSet.row_set_num),
                                     CASE
                                       WHEN rowSet.row_filter_sql IS NULL THEN ''
                                       ELSE 'filter = `' || rowSet.row_filter_sql || '`, '
                                     END,
                                     '% of NULLs = ' || rowSet.null_percentage,
                                     CASE
                                       WHEN rowSet.pattern IS NULL THEN ''
                                       ELSE ', masking pattern = `' || rowSet.pattern || '`'
                                     END));
        effectiveNullPercentage := CASE maskedColumn.nullable WHEN 'Y' THEN rowSet.null_percentage ELSE 0 END;
        effectivePattern := CASE
                              WHEN effectiveNullPercentage < AllNullsPercentage THEN effective_pattern(rowSet.pattern)
                              ELSE NULL
                            END;

        updateSql := utl_lms.format_message('
            UPDATE %s.%s
            SET %s = ned_data_mask_pkg.generate_random_data(:pattern, :null_percentage), LAST_UPDATE_DATE = SYSDATE
            WHERE %s IS NOT NULL%s',
            maskedColumn.owner, maskedColumn.table_name, maskedColumn.column_name, maskedColumn.column_name,
            CASE
              WHEN rowSet.row_filter_sql IS NULL THEN ''
              ELSE Lf || ' AND ' || rowSet.row_filter_sql
            END);
          debug(Lf || updateSql || Lf || ' using ''' || effectivePattern || ''', ' || effectiveNullPercentage);
          EXECUTE IMMEDIATE updateSql USING effectivePattern, effectiveNullPercentage;
      END LOOP;
      EXECUTE IMMEDIATE utl_lms.format_message('ALTER TABLE %s.%s ENABLE ALL TRIGGERS',
                                               maskedColumn.owner, maskedColumn.table_name);
    END LOOP;

    debug('Done.');
  EXCEPTION
    WHEN OTHERS THEN
      ROLLBACK;
      RAISE;
  END;
END;
/
