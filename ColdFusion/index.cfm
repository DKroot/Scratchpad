<cfoutput>
<html>
<head>
<title>Test bed</title>
</head>
<body>
<h2>Miscellaneous CF demos</h2>

<!--- Error reporting
<h3>Sample error</h3>
<cfscript>
    Throw("Sample error");
</cfscript>
--->

<!--- Array join
<h3>Array join</h3>
<cfscript>
    a1 = [1, 2];
    a2 = [3, 4];
    ArrayAppend(a1, a2);
    WriteOutput("<p>Joined array: ");
    WriteDump(a1);
    WriteOutput("</p>");
</cfscript>
--->

<!--- Repeated var declaration
<h3>Repeated var declaration</h3>
<cfscript>
    function foo(required string message) {
        var bar = "baz";
        var bar = message;
        return bar;
    }
</cfscript>
<cfoutput>
<p>variable value = '#foo("A quick brown fox jumps over a lazy dog.")#'</p>
</cfoutput>
--->

<!--- Dynamic Evaluation
<h3>Dynamic Evaluation</h3>
<cfform>
<cfscript>
    value="value='Dynamically generated value attribute'";
    //Evaluate('<cfinput name="foo" ' & value); //Generates error
</cfscript>
</cfform>
--->

<!--- <pre>
<h3>&lt;pre&gt;</h3>
Here is pre-formatted text:
<pre>
Line 1
    <b>Indented Line 2</b>
Line3
</pre>

Indented &lt;pre&gt;:
    <pre>
    Line 1
        <b>Indented Line 2</b>
    Line3
    </pre>

Indented &lt;pre&gt; with outdented text:
    <pre>
Line 1
    <b>Indented Line 2</b>
Line3
    </pre>

Inline &lt;pre&gt; with outdented text: <pre>
Line 1
    <b>Indented Line 2</b>
Line3</pre>

Inline &lt;pre&gt; with inline text: <pre>Line 1
    <b>Indented Line 2</b>
Line3</pre>
Text after &lt;pre&gt;
--->

<!--- Forms and regex validations -->
<cfscript>
/**
 * See StrLib
 * Counterpart to HexToString - converts an ASCII string to hexadecimal.
 *
 * @param str    String to convert to hex. (Required)
 * @return Returns a string.
 * @author Chris Dary (umbrae@gmail.com)
 * @version 1, May 8, 2006
 */
function stringToHex(str) {
  var hex = "";
  for (var i=1; i <= len(str); i++) {
    hex = hex & Right("0" & FormatBaseN(Asc(Mid(str,i,1)),16), 2);
  }
  return UCase(hex);
}
</cfscript>

<h3>Forms and regex validations</h3>
<p>Submitted form values
<pre>
<cfscript>
    for (param in form) {
        WriteOutput("#param# = {#HTMLEditFormat(form[param])#} (length: #Len(form[param])#, raw hex: #stringToHex(form[param])#)#chr(10)#");
    }
</cfscript>
</pre>
</p>

<p/>
<cfform name="demoForm" method="POST">
An input:
    <cfinput type="text" name="input1" /><br>

* Required input:
    <cfinput type="text" name="input2" required="yes" validate="noblanks"
        message="Input is required and can not contain blanks" /><br>

Disabled input:
    <cfinput type="text" name="input3" disabled="true" value="foo" /><br>
    <input type="checkbox" onChange="this.form.input3.disabled=false" />Enable / Disable<br>

Drop-down:
    <!--- cfquery name="tradingPartners" datasource="NVPPRD" --->
    <cfscript>
        q = new query();
        q.setDatasource("NVPPRD");
        tradingPartnersRS = q.execute(sql="
        SELECT
            tp1.tp_code code1,
            tp1.tp_description desc1
        FROM
            NV_FACTS_TP_DIM tp1
        ORDER BY tp1.tp_description");
        //WriteDump(tradingPartnersRS);
        tradingPartners = tradingPartnersRS.getResult();
        //WriteDump(tradingPartners);
    </cfscript>
    <!--- /cfquery --->

    <cfselect name="tradingPartners" query="tradingPartners" display="desc1" value="code1"/><br>

Text area (2000 characters maximum):<br>
    <cftextarea name="textarea" cols="80" rows="20"
                maxlength="2000" validate="maxlength"
                message="A text area's input cannot exceed 2000 characters"/><br>
  <br /><cfinput type="submit" name="action" value="Submit" />
</cfform>
--->

<!--- cfsavecontent
<h3>cfsavecontent</h3>
<cfsavecontent variable="report">
<cfif false>
<p>"Then" part inside <b>cfsavecontent</b></p>
<cfelse>
<p>"Else" part inside <b>cfsavecontent</b></p>
</cfif>
</cfsavecontent>
#report#
--->

<!--- Currency formatting
<h3>Currency formatting</h3>
<p>
    <cfloop list="123456.7899;123456;.00;-123456.78;123,456.78;$123,456.78;(123,456.78);xyz;100,00"
        delimiters=";" index="value">
        Value: #value#<br>
        Is Currency? #LSIsCurrency(value)#<br>
        <cfif LSIsCurrency(value)>
            <cfset value = LSParseCurrency(value)>
            Using parsed value: #value#<br>
            Formatted local: #LSCurrencyFormat(value, "local")#<br>
            Parsed formatted local: #LSParseCurrency(LSCurrencyFormat(value, "local"))#<br>
            Formatted international: #LSCurrencyFormat(value, "international")#<br>
            Parsed formatted international: #LSParseCurrency(LSCurrencyFormat(value, "international"))#<br>
            Formatted none: #LSCurrencyFormat(value, "none")#<br>
            Parsed formatted none: #LSParseCurrency(LSCurrencyFormat(value, "none"))#
        </cfif>
        <hr>
    </cfloop>
</p>
--->

<!--- Rounding
<h3>Rounding</h3>
<p>
    1.005 - 1.00 >= 0.005? #1.005 - 1.00 GE 0.005#<br>
    1.005 - 1.00 > 0.005? #1.005 - 1.00 GT 0.005#<br>
    1.005 - 1.00 >= 0.004? #1.005 - 1.00 GE 0.004#<br>
    Round( (1.005 - 1.00)*100 )/100 >= 0.01? #Round( (1.005 - 1.00)*100 )/100 GE 0.01#<br>
    Round( (1.0051 - 1.00)*100 )/100 >= 0.01? #Round( (1.0051 - 1.00)*100 )/100 GE 0.01#<br>
    Round( (1.006 - 1.00)*100 )/100 >= 0.01? #Round( (1.006 - 1.00)*100 )/100 GE 0.01#<br>
    Round( (1.009 - 1.00)*100 )/100 >= 0.01? #Round( (1.009 - 1.00)*100 )/100 GE 0.01#<br>
</p>
--->

<!--- Structures ---
<cfscript>
    value = StructGet("foo.bar");
    WriteOutput("<p>Non-existent structure value:");
    WriteDump(value);

    //ERROR
    //value2 = foo["baz"];

    foo.bar.baz = "value2";
    WriteOutput("<p>Existing key value: #foo.bar.baz#</p>");

    // ERROR:
    //StructUpdate(struct, "key2", "value2");
    StructInsert(foo.bar, "qux", "value3");
    WriteOutput("<p>Inserted key value: #foo.bar.qux#</p>");
    WriteOutput("<p>Inserted key value: #foo.bar['qux']#</p>");
</cfscript>
--->

<!--- HTML escape
<h3>HTML escape</h3>
<cfscript>
    message = HTMLEditFormat("A message with the special characters: <>| , second part , third part");
    WriteOutput("<p>#message#</p>");
    WriteOutput("Source: #HTMLCodeFormat(message)#");
    replaced = Replace(message, " , ", ">", "all");
    WriteOutput("<p>#replaced#</p>");
    WriteOutput("Source: #HTMLCodeFormat(replaced)#");
</cfscript>
<pre><cfloop list='#replaced#' delimiters=">" index="part">Part: #part##chr(10)#</cfloop></pre>
--->

<!--- Iteration over array
<h3>Iteration over array</h3>
<cfscript>
    a = ["Item 1", 2];
    for (element in a) {//ERROR prior to 9.0.1
        WriteOutput("Element: #element#<br/>");
    }
    //for(i=1; i<=ArrayLen(a); i++) {
  //  element = a[i];
</cfscript>
--->

<!--- Lists and functional parameters
<cfscript>
    runningTotal = "";
    step = 0;
    listLoop("1,,3", command);
    step = 0;
    listLoop("", command);

    function command(item) {
        runningTotal &= item;
        step++;
        WriteOutput("Running accumulator... Step #step#: runningTotal=#runningTotal#<br/>");
    }

    function listLoop(required string list, command) {
        var arr = listToArray(list);
        for (var item in arr) {
                command(item);
        }
    }
</cfscript>
--->

<!--- Mid() function
<h3>Mid() function</h3>
<cfscript>
    s = "String";
    WriteOutput("Mid(s, 4, Len(s)) = '#Mid(s, 4, Len(s))#'");
    //ERROR:
    //WriteOutput("Mid(s, 4) = #Mid(s, 4)#");
</cfscript>
--->

<!--- HTTP request info --->
<h3>HTTP request info</h3>
<cfscript>
    WriteOutput("<p>GetHttpRequestData().headers:</p>");
    WriteDump(GetHttpRequestData().headers);
    WriteOutput("<p>CGI variables:</p>");
    WriteDump(CGI);
    WriteOutput("<p>GetPageContext().GetRequest():</p>");
    r = GetPageContext().GetRequest();
    WriteDump(r);
    WriteOutput("<p>GetPageContext().GetRequest().getRequestURL() = #r.getRequestURL()#</p>");
    WriteOutput("<p>GetPageContext().GetRequest().getQueryString() = #r.getQueryString()#</p>");
    WriteOutput("<p>GetPageContext().GetRequest().getRequestURI() = #r.getRequestURI()#</p>");
    WriteOutput("<p>GetPageContext().GetRequest().getContextPath() = #r.getContextPath()#</p>");
    WriteOutput("<p>GetPageContext().GetRequest().getServletPath() = #r.getServletPath()#</p>");
    //WriteOutput("<p>Original URL: #r.getRequestURL()#?#r.getQueryString()#</p>");

    URL.foo = "bar";
    updatedURL = r.getRequestURL() & "?";
    for (param in URL) {
        updatedURL &= "&" & param & "=" & URL[param];
    }
    WriteOutput("<p>Updated URL (parameter foo=bar): #updatedURL#</p>");
</cfscript>

<!--- Remove transient cookie
<cffunction name="removeCookie">
  <cfargument name="name" required="yes" type="string">
  <cfoutput><p>Removing cookie: #arguments.name#</p></cfoutput>
  <cfcookie name="#arguments.name#" expires="now">
</cffunction>

<cfscript>
    removeCookie("RAPActiveCart");
/cfscript>
--->

<!--- Object metadata
<h3>Object metadata</h3>
<cfscript>
    u1 = new Util();
    WriteDump(getMetadata(u1));
    WriteOutput("<p>Does init() exists?:");
    WriteOutput(" #u1.doesMethodExist(u1, "init")#</p>");
    WriteOutput("<p>Does isAmountGreater() exists?:");
    WriteOutput(" #u1.doesMethodExist(u1, "isAmountGreater")#</p>");
</cfscript>
--->

<!--- Query Metadata
<h3>Query Metadata</h3>
<cfscript>
    q = new query();
    q.setDatasource("NVPPRD");
    q.setUsername("DWRAPAPP");
    q.setPassword("DWRAPAPP$26");
    tradingPartnersRS = q.execute(sql="
SELECT
    tr.cart_txn_id,
    tr.docno,
    tr.authority_docno,
    tr.other_docno,
    tr.action_code,
    tr.sgl_debit_amt,
    tr.facts_tp_code,
    tp.tp_description,
    tr.can,
    tr.fy,
    tr.paysched,
    tr.approp,
    tr.icd,
    acs.project_nbr,
    tr.cart_id,
    tr.gl_posted_date,
    tr.nbrss_procdate,
    to_char(tr.created_date, 'YYYY-MM-DD HH24:MI:SS') AS created,
    to_char(tr.last_updated_date, 'YYYY-MM-DD HH24:MI:SS') AS last_updated,
    c.cart_status,
    c.last_updated_by_user_id,
    to_char(c.last_updated_date, 'YYYY-MM-DD HH24:MI:SS') AS cart_last_updated
FROM
    NV_REIMBURSABLE_BILLING tr
    JOIN NV_REIMBURSABLE_BILLING_CART c
        ON tr.cart_id = c.cart_id
    LEFT OUTER JOIN NV_ACS_DIM acs
        ON tr.can = acs.acs_can
    LEFT OUTER JOIN NV_FACTS_TP_DIM tp
        ON tr.facts_tp_code = tp.tp_code
WHERE
    tr.cart_id = 'TEST'
    -- AND tr.action_code IN ('REIMB AUTH' ,'OBLIGATION' ,'BILLING' ,'ACCR/DISB' )
ORDER BY
    action_code
    ");
    WriteOutput("<p>Query Object Metadata:</p>");
    WriteDump(getMetaData(q));
    WriteOutput("<p>Result Metadata:</p>");
    rsMetaData = getMetaData(tradingPartnersRS.getResult());
    WriteDump(rsMetaData);

    WriteOutput("<p>Columns:<br>");
    for (column in rsMetaData) {
        WriteOutput("#column.name# : #column.typeName#<br>");
    }
    WriteOutput("</p>");

    WriteOutput("<p>Record Count: #tradingPartnersRS.getResult().RecordCount#</p>");
    WriteOutput("<p>SQL: <pre>#tradingPartnersRS.getPrefix().SQL#</pre></p>");
    WriteOutput("<p>Result Prefix:</p>");
    WriteDump(tradingPartnersRS.getPrefix());
    WriteOutput("<p>Result:</p>");
    WriteDump(tradingPartnersRS.getResult());
</cfscript>
--->

<!--- Util.FiscalYear()
<h3>Util.FiscalYear()</h3>
<cfscript>
    u2 = new Util();
    WriteOutput("<p>Current FY: #u2.FiscalYear()#</p>");
    WriteOutput("<p>FY of 2010-12-31: #u2.FiscalYear(CreateDate(2010, 12, 31))#</p>");
</cfscript>
--->

<!--- Util.ParentPath()
<cfinvoke component="components.Util" method="ParentPath"
    path="#GetPageContext().GetRequest().getRequestURL()#" returnvariable="parent" />

<cfoutput>
<p>New path: #parent#/newpage.cfm</p>
</cfoutput>
--->

<!--- Wrap() Functions
<h3>Wrap() Functions</h3>
Wrapping 100 characters line:
<cfset s = RepeatString(" ", 10) & RepeatString("123456789 ", 8) & RepeatString(" ", 10)>
<cfset blank = RepeatString(" ", 100)>
<cfset slw120 = new StrLib().StrLibWrap(s, 120)>
<cfset slw60 = new StrLib().StrLibWrap(s, 60)>
<cfset slw65 = new StrLib().StrLibWrap(s, 65)>
<cfset bw120 = new Util().betterWrap(s, 120)>
<cfset bw60 = new Util().betterWrap(s, 60)>
<cfset bw65 = new Util().betterWrap(s, 65)>
<pre>
s                  = "#s#"
Wrap(s, 120)       = "#Wrap(s, 120)#"
Wrap(s, 60)        = "#Wrap(s, 60)#"
Wrap(s, 60, true)  = "#Wrap(s, 60, true)#"
Wrap(s, 60, false) = "#Wrap(s, 60, false)#"
Wrap(s, 65)        = "#Wrap(s, 65)#"
StrLibWrap(s, 120) = "#slw120#"
StrLibWrap(s, 60)  = "#slw60#"
StrLibWrap(s, 65)  = "#slw65#"
betterWrap(s, 120) = "#bw120#"
betterWrap(s, 60)  = "#bw60#"
betterWrap(s, 65)  = "#bw65#"
</pre>

Wrapping 100 characters blank:
<cfset slw60 = new StrLib().StrLibWrap(blank, 60)>
<cfset bw60 = new Util().betterWrap(blank, 60)>
<pre>
blank                 = "#blank#"
Wrap(blank, 60)       = "#Wrap(blank, 60)#"
StrLibWrap(blank, 60) = "#slw60#"
betterWrap(blank, 60) = "#bw60#"
</pre>

Wrap(blank, 60) lines:<br>
<cfloop list="#Replace(Wrap(blank, 60), " ", "_", "all")#" delimiters="#chr(10)#" index="line">
line: "#line#"<br>
</cfloop>

StrLibWrap(blank, 60) lines:<br>
<cfloop list="#Replace(slw60, " ", "_", "all")#" delimiters="<br>" index="line">
line: "#line#"<br>
</cfloop>
--->

</body>
</html>
</cfoutput>