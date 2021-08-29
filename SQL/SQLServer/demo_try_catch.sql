BEGIN TRY
  -- Generate a divide-by-zero error.
  SELECT 1 / 0;
END TRY BEGIN CATCH
  SELECT
    error_number() AS errornumber, error_severity() AS errorseverity, error_state() AS errorstate,
    error_procedure() AS errorprocedure, error_line() AS errorline, error_message() AS errormessage;
END CATCH;
GO

BEGIN TRY
  -- Generate a divide-by-zero error.
  SELECT 1 / 0;
END TRY BEGIN CATCH
  THROW;
END CATCH;
GO