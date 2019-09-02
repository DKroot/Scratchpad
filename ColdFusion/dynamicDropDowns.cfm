<html>
<head>
<title>Dynamic drop-downs</title>
</head>
<body>
<h2>Dynamic drop-downs</h2>
    <cfscript>
        application.webApp = RemoveChars(application.Util.parentPath(CGI.SCRIPT_NAME), 1, 1);
    </cfscript>
    <cfform name="myForm">
        <cfselect name="FY" bind="cfc:#application.webApp#.DropDowns.readBCFYs()" bindonload="true" value="FY">
            <option>Processing...</option>
        </cfselect>
        <cfselect name="CAN" bind="cfc:#application.webApp#.DropDowns.readBCCANs({FY})" value="CAN">
            <option>Processing...</option>
        </cfselect>
    </cfform>
</body>
</html>

<!---
<html>
<head>
</head>
<body>
<cfform name="mycfform">
    <!---
        The States selector.
        The bindonload attribute is required to fill the selector.
    --->
    <cfselect name="state" bind="cfc:CFDemos.bindFcns.getstates()" bindonload="true">
        <option name="0">--state--</option>
    </cfselect>
    <cfselect name="city" bind="cfc:CFDemos.bindFcns.getcities({state})">
        <option name="0">--city--</option>
    </cfselect>
</cfform>
</body>
</html>--->