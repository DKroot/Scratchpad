ALTER TABLE ned_masked_data_formats RENAME COLUMN masking_pattern TO pattern;

DELETE FROM ned_masked_data_formats
WHERE format_name = 'FORMATTED_SSN';