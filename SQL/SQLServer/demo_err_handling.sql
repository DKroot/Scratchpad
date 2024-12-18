BEGIN TRY
  -- Generate a divide-by-zero error.
  SELECT 1 / 0;
END TRY BEGIN CATCH
  SELECT error_number() AS errornumber, error_severity() AS errorseverity, error_state() AS errorstate,
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

-- Generate a divide-by-zero error.
SELECT 1 / 0;

BEGIN TRY
  -- `LINENO` converts batch line # to the actual line # for middle-of-file batches
  lineno 21;
  -- keep it matching the actual line #

  -- Generate a divide-by-zero error.
  SELECT 1 / 0;
END TRY BEGIN CATCH
  DECLARE @err_msg NVARCHAR(4000), @err_severity INT, @err_state INT;
  SET @err_msg = 'At line #' + cast(error_line() AS VARCHAR(50)) + ': ' + error_message();
  SET @err_severity = error_severity();
  SET @err_state = error_state();
  RAISERROR (@err_msg, @err_severity, @err_state);
END CATCH;
GO

/* arbitrary error code >= 50000 */
DECLARE @arg_error_num INT = 63372, @msg VARCHAR(255);
SELECT @msg = MESSAGETEXT
FROM dbo.appl_messages
WHERE KEY_VALUE = 'RP_MSG_0';
THROW @arg_error_num, @msg, 0;
GO