--liquibase formatted sql

--changeset DK:rename_ned_masked_data_formats_pattern runOnChange:true
ALTER TABLE ned_masked_data_formats RENAME COLUMN pattern TO masking_pattern;

--changeset DK:update_ned_masked_data_formats runOnChange:true
INSERT INTO ned_masked_data_formats (format_name, masking_pattern, description)
VALUES ('FORMATTED_SSN', '{\d*3}-{\d*2}-{\d*4}', 'SSN separated by dashes');