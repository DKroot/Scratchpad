CREATE OR REPLACE PROCEDURE korobskd.r_mv_in_place(
    mv IN VARCHAR2,
    transactional IN BOOLEAN := TRUE,
    skip_index IN VARCHAR2 := '*NONE*')
  --
  -- Refresh an MV while all non-unique indexes are disabled
  -- Warning: You must rebuild indexes afterwards/
  -- transactional (automic_refresh) could be set to FALSE to improve speed, but you might lose data in an MV on error.
  --
  -- Out-of-place refreshes are recommended (https://docs.oracle.com/database/121/DWHSG/refresh.htm#DWHSG9081) instead
  -- of using this SP. You should be able to do out-of-place refreshes directly (they rebuild indexes afterwards).
  -- Out-of-place refreshes have more restrictions (e.g. no LOBs or MV constraints) and will not work on all MVs.
IS
BEGIN
  BEGIN
    disable_indexes(mv, skip_index) ;

    debug('Refreshing ' || mv || ' in-place ...') ;
    dbms_mview.refresh(mv, atomic_refresh => transactional) ;
  EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE ('Error!');
    DBMS_OUTPUT.PUT_LINE (SQLERRM);
    DBMS_OUTPUT.PUT_LINE (DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);

    rebuild_unusable_indexes(mv);
    RAISE;
  END;

  rebuild_unusable_indexes(mv);
  debug('Success.') ;
END;
/