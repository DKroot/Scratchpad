@echo off
liquibase --password=%D2_PWD% --changeLogFile=liquibase_migration.xml update