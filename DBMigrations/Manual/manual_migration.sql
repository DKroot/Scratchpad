ALTER TABLE ned_masked_data_formats RENAME COLUMN pattern TO masking_pattern;

INSERT INTO ned_masked_data_formats (format_name, masking_pattern, description)
VALUES ('FORMATTED_SSN', '{\d*3}-{\d*2}-{\d*4}', 'SSN separated by dashes');

@@../src/ned_data_mask_pkg.sql