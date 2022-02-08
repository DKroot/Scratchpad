-- Current default schema
SELECT schema_name() AS default_schema;

/*
-- If this DDL is not commented out, IDEA recognizes `temp_sample_data` below
SELECT 42 AS foo
INTO dbo.temp_sample_data
*/

-- Qualified reference
SELECT *
FROM dbo.temp_sample_data;

/*
Implicit name resolution

When database objects are referenced by using a one-part name, SQL Server first looks in the user's default schema.
If the object is not found there, SQL Server looks next in the dbo schema.

Note: `sys` schema objects must be qualified in modern MS SQL versions

Only query plans with the same user ID are candidates for reuse. When uid = -2, it means that the query does not depend
on implicit name resolution, and can be shared among different user IDs.

See:
https://docs.microsoft.com/en-us/sql/relational-databases/security/authentication-access/ownership-and-user-schema-separation
*/
-- Unqualified name resolves to `dbo.temp_sample_data`
-- IDEA: recognizes name *only when its DDL is available above*
SELECT *
FROM temp_sample_data;

DROP TABLE dbo.temp_sample_data;

/*
`sys` schema objects must be qualified in modern MS SQL versions
*/
-- Default schemas per user
SELECT name AS user_name, default_schema_name
FROM sys.database_principals
WHERE type = 'S';