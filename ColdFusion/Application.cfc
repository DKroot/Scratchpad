<cfcomponent output="false">
<cferror type="exception" template="errorReport.cfm" mailto="korobskd@mail.nih.gov;allamr@mail.nih.gov" />
<cfscript>
    boolean function onApplicationStart() {
        application.sessionManagement = true;

        var ORACLE_DATASOURCE_RAP = "NVPPRD";
        var location = "";
        application.DBDialect = FileRead(location & "rap_dbdialect.txt");
        application.systemGroupEmail = "korobskd@mail.nih.gov";
        if (application.DBDialect eq "") {
            application.DBDialect = "Oracle";
        }
        application.dataSource = ORACLE_DATASOURCE_RAP;
        application.username = Trim(FileRead(location & "rap_user.txt")); // Trim \0 characters
        application.password = Trim(FileRead(location & "rap_pass_#ORACLE_DATASOURCE_RAP#.txt"));
        application.Util = new Util();
        return true;
    }

    boolean function onRequestStart() {
        application.sessionManagement = true;

        return true;
    }
</cfscript>
</cfcomponent>