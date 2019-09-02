\set ON_ERROR_STOP on
\set ECHO all

--@formatter:on
CREATE TABLE IF NOT EXISTS tmp_demo_psql (
                                             id        INT          NOT NULL PRIMARY KEY,
                                             col1      VARCHAR(100) NOT NULL,
                                             col2      VARCHAR(100),
                                             load_date DATE DEFAULT current_date
);

INSERT INTO tmp_demo_psql(id, col1, col2) --
VALUES (1, 'foo', 'bar')
ON CONFLICT DO NOTHING;
-- endregion

COPY tmp_demo_psql TO :'dir'
    '/template_job_export.csv' (FORMAT CSV, HEADER ON);