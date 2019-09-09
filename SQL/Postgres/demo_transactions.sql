\set ON_ERROR_STOP on
\set ECHO all

\if :{?schema}
SET search_path = :schema;
\endif

-- JetBrains IDEs: start execution from here
SET TIMEZONE = 'US/Eastern';

DROP TABLE IF EXISTS tmp_demo_transactions;
CREATE TABLE tmp_demo_transactions (
  key VARCHAR(100) PRIMARY KEY,
  tx_id BIGINT,
  load_date DATE DEFAULT current_date
);

DROP PROCEDURE IF EXISTS ins_tx_default_scope(TEXT);
CREATE PROCEDURE ins_tx_default_scope(a_key TEXT)
  LANGUAGE PLpgSQL AS $block$
DECLARE tx_id BIGINT;
BEGIN
  SELECT txid_current_if_assigned() INTO tx_id;
  RAISE NOTICE 'TX ID: `%`', tx_id;

  INSERT INTO tmp_demo_transactions(key, tx_id)
  SELECT a_key, txid_current();
END $block$;

DO $block$
  BEGIN
    CALL ins_tx_default_scope('foo');
    CALL ins_tx_default_scope('bar');
  END $block$;

DO $block$
  BEGIN
    CALL ins_tx_default_scope('baz');
    CALL ins_tx_default_scope('qux');
  END $block$;

DROP PROCEDURE IF EXISTS ins_tx_with_commits(TEXT);
CREATE PROCEDURE ins_tx_with_commits(a_key TEXT)
  LANGUAGE PLpgSQL AS $block$
DECLARE tx_id BIGINT;
BEGIN
  SELECT txid_current_if_assigned() INTO tx_id;
  RAISE NOTICE 'TX ID: `%`', tx_id;

  INSERT INTO tmp_demo_transactions(key, tx_id)
  SELECT a_key, txid_current();
  COMMIT;

  SELECT txid_current_if_assigned() INTO tx_id;
  RAISE NOTICE 'TX ID: `%`', tx_id;

  INSERT INTO tmp_demo_transactions(key, tx_id)
  SELECT a_key || ',' || a_key, txid_current();
  COMMIT;
END $block$;

DO $block$
  BEGIN
    CALL ins_tx_with_commits('quux');
    CALL ins_tx_with_commits('quuz');
  END $block$;

-- [2D000] ERROR: invalid transaction termination
/*DO $block$
  BEGIN
    CALL ins_tx_with_commits('corge');
    CALL ins_tx_with_commits('grault');
  EXCEPTION
    WHEN OTHERS THEN --
      RAISE NOTICE E'Processing FAILED';
      RAISE;
  END $block$;*/

-- [2D000] ERROR: invalid transaction termination
/*DO $outer_block$
  BEGIN
    DO $block$
      BEGIN
        CALL ins_tx_with_commits('corge');
        CALL ins_tx_with_commits('grault');
      END $block$;
  EXCEPTION
    WHEN OTHERS THEN --
      RAISE NOTICE E'Processing FAILED';
      RAISE;
  END $outer_block$;*/

DROP PROCEDURE IF EXISTS ins_tx_with_commits_and_exception_block(TEXT);
CREATE PROCEDURE ins_tx_with_commits_and_exception_block(a_key TEXT)
  LANGUAGE PLpgSQL AS $block$
DECLARE tx_id BIGINT;
BEGIN
  SELECT txid_current_if_assigned() INTO tx_id;
  RAISE NOTICE 'TX ID: `%`', tx_id;

  INSERT INTO tmp_demo_transactions(key, tx_id)
  SELECT a_key, txid_current();
  COMMIT;

  SELECT txid_current_if_assigned() INTO tx_id;
  RAISE NOTICE 'TX ID: `%`', tx_id;

  INSERT INTO tmp_demo_transactions(key, tx_id)
  SELECT a_key || ',' || a_key, txid_current();
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN RAISE WARNING 'Exception occurred';
  RAISE;
END $block$;

-- [2D000] ERROR: cannot commit while a subtransaction is active
/*DO $block$
  BEGIN
    CALL ins_tx_with_commits_and_exception_block('waldo');
    CALL ins_tx_with_commits_and_exception_block('fred');
  END $block$;*/