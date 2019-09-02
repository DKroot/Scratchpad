ALTER TABLE ned_masked_data_formats RENAME COLUMN masking_pattern TO pattern;

DELETE FROM ned_masked_data_formats
WHERE format_name = 'FORMATTED_SSN';

@@../tags/v0.9/src/ned_data_mask_pkg.sql