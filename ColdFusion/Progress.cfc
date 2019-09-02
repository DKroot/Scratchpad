<cfcomponent>
<!--- This function simulates the time taken
    by and operation by using sleep functions.
    It increments the progressbar status by 1/10 each time the
    progressbar bind expression calls it (that is, each time the
    time specified by the cfprogressbar interval attribute passes.
--->
    <cffunction name="getstatus" access="remote">
            <cfset str = StructNew()>
            <cfset str.message = "Saving Data">
            <cfif  NOT IsDefined("session.STATUS")>
                <cfset session.STATUS = 0.1>
                <cfscript>
                    Sleep(200);
                </cfscript>
            <cfelseif session.STATUS LT 0.9>
                <cfset session.STATUS=session.STATUS + .1>
                <cfscript>
                    Sleep(200);
                </cfscript>
            <cfelse>
                <cfset str.message = "Done...">
                <cfset session.STATUS="1.0">
            </cfif>
            <cfset str.status = session.STATUS>
            <cfreturn str>
    </cffunction>

</cfcomponent>