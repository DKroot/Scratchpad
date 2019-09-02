<cfscript>
    user = {
        userName = "unknown",
        fullName = "Unknown User",
        role = "general user"
    };
    if (!IsDefined("error")) { // define sample error for testing error report itself
        error = {
            MailTo = "",
            Diagnostics = "Sample error",
            TagContext = [],
            QueryString = "",
            HTTPReferer = CGI.HTTP_REFERER,
            Browser = CGI.HTTP_USER_AGENT,
            DateTime = Now()
        };
    }
</cfscript>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>Error Report</title>
    <style type="text/css" media="print, projection, screen">
        .redtxt{
            font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
            color:#FF0000;
            font-size: 13px;
            font-weight: bold;
            line-height: 17px;
            margin-bottom: 11px;
        }

        .smalltxt{
            font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
            color: #1A1A47;
            font-size: 12px;
            font-weight: bold;
            line-height: 16px;
            margin-bottom: 11px;
        }
    </style>
</head>
<body>

<table width="1000" cellpadding="0" cellspacing="0" border="0" align="center" bgcolor="#ffffff">
  <tr>
    <td align="left" valign="top">
        <cfoutput>
        <!-- InstanceBeginEditable name="Content" -->
        <cfform action="mailAction.cfm "method="post">
          <cfinput type="hidden" name="from" value="#user.userName#@mail.nih.gov">
          <cfinput type="hidden" name="to" value="#error.MailTo#">
          <cfinput type="hidden" name="subject" value="Error Report">
          <cfinput type="hidden" name="info" value="Thank you for your report submission! The support team will get back to you as soon as possible.">
          <table cellpadding="0" cellspacing="0" border="0" align="center" width="95%">
            <tr><td class="redtxt">Error Report</td></tr>
            <tr>
              <td align="left">
                  <p><span class="smalltxt">A system error occurred. The technical team is sorry that you ran into
                  this problem.</span> Please log out, close the browser and repeat the steps that you tried to do.
                  If you continue to have this problem, please submit an error report.
                  <p class="smalltxt">There is no need in sending a separate email.
                  Please submit this report using the "Submit" button below.</p>
                  <p>The support team will get back to you as soon as possible</p>
                  <p>Describe the exact sequence of steps that led to this error. Be brief, but specific. Include
                  all specific data entered. The following is an example of a good sequence:</p>
                  <p>1. Billing/Collections > New transaction > the first Go button<br>
                  2. CAN = 8330368 > the second Go button<br>
                  3. Select one unbilled and one RO<br>
                  4. Enter .00 in the amount field<br>
                  5. Add to Cart<br>
                  Actual result: error occurs<br>
                  Expected result: An edit should have prevented $.00 from submission</p>

                  <div align="center">
                  <p><b>Steps, reproducing ths problem</b><span class="message">*</span></p>
                  <cftextarea cols="80" rows="15" name="usertext" required="true"
                              message="Please enter steps that reproduce this problem"/>
                  </div>
              </td>
            </tr>
            <tr>
              <td valign="top"><img src="images/point.gif" width="1" height="10" border="0" /></td>
            </tr>
            <tr>
              <td align="center"><cfinput type="submit" name="submit" value="Submit"></td>
            </tr>
            <tr>
              <td>
                <cfsavecontent variable="techinfo">
                  <p>Technical Details included in the report:</p>

                  <ul>
                      <li><b>Error: </b><span class="redtxt">#error.Diagnostics#</span></li>

                      <li><b>SQL:</b>
                        <cfif IsDefined("error.RootCause.SQL")>
                          <p>
                          <cfscript>
                              lineNumber = 1;
                              problemLineMatch = REFind("at line (\d+)", error.Diagnostics, 1, true);
                              if (problemLineMatch.pos[1] == 0) {
                                  problemLine = 0;
                              } else {
                                  problemLine = Mid(error.Diagnostics,
                                          problemLineMatch.pos[2], problemLineMatch.len[2]);
                                  WriteOutput("At SQL, line #problemLine#<br>");
                              }
                          </cfscript>
                          <pre><cfloop list="#error.RootCause.SQL#" delimiters="#chr(10)#" index="line"><cfif
                                      lineNumber eq problemLine><b></cfif>#LJustify(lineNumber & ":", 5)##HTMLEditFormat(
                                      application.Util.betterWrap(line, 120) )#<cfif lineNumber eq
                                      problemLine></b></cfif>#chr(10)#<cfset lineNumber++></cfloop></pre>
                          <cfif IsDefined("error.RootCause.where") and error.RootCause.where neq "">
                          Executed with bind parameters:<br>
                          <!--- Iterate over bind parameters. Note multi-character delimiter: " , " --->
                          <pre><cfloop
                             array='#ListToArray(HtmlEditFormat(error.RootCause.where), " , ", true, true)#'
                                   index="param">#application.Util.betterWrap(Trim(param), 120)##chr(10)#</cfloop></pre>
                          </cfif>
                          </p>
                        </cfif>
                      </li>

                      <li><b>ColdFusion Context:</b><p>
                        <cfset displaySource = true>
                        <cfloop array="#error.TagContext#" index="entry">
                                  <cfif entry.line gt 0>
  <!---
  Check for weird TagContext entries not pointing to the source files. The example:
  {RAW_TRACE={Caused by: java.sql.SQLException: [Macromedia][Oracle JDBC Driver][Oracle]ORA-12899: value too large for
  column "DWADM_SUPT"."NV_REIMBURSABLE_BILLING_CART"."CART_STATUS_COMMENT" (actual: 2063, maximum: 2000)},
  ID={CF_WORKERTHREAD},TEMPLATE={actual: 2063, maximum},LINE={-1},TYPE={CFML},COLUMN={0}}
  --->
                            At #entry.template#, line #entry.line#<br>
                            <cfif displaySource>
                                <cfset lineNumber = 1>
                                <pre>
                        &##10;<cfloop file="#entry.template#" index="line">
                                    <cfif lineNumber + 5 ge #entry.line# and lineNumber - 5 LE #entry.line#>
                                        <cfif lineNumber eq entry.line><b></cfif>#LJustify(lineNumber & ":", 5)##HTMLEditFormat(
                                            application.Util.betterWrap(line, 120) )#<cfif lineNumber eq
                                            entry.line></b></cfif>&##10;</cfif>
                                    <cfset lineNumber++>
                                </cfloop>
                                </pre>
                                <!---<cfset displaySource = false>--->
                            </cfif>
                            </cfif>
                        </cfloop></p>
                      </li>

                      <li><b>Requested:</b> #application.Util.betterWrap(
                              application.Util.addURLParam(GetPageContext().GetRequest().getRequestURL(),
                              error.QueryString), 120 )#
                      </li>

                      <li><b>Form:</b><cfif StructCount(form) gt 0><br></cfif>
                        <pre><cfloop collection="#form#" item="item">#item# = #HTMLEditFormat(
                            application.Util.betterWrap(StructFind(form, item), 120) )##chr(10)#</cfloop></pre>
                      </li>

                      <li><b>Previous page:</b> #application.Util.betterWrap(error.HTTPReferer, 120)#</li>

                      <li><b>Submitter:</b> #user.fullName# (#user.role#)</b></li>

                      <li><b>Browser:</b> #error.Browser#</li>

                      <li><b>Error occurred at:</b> #LSDateFormat(error.DateTime)#
                          #LSTimeFormat(error.DateTime, "HH:mm:ss")#</li>
                    </ul>
                </cfsavecontent>

                #techinfo#
                <cfinput type="hidden" name="text" value="#techinfo#">
              </td>
            </tr>
          </table><br/><br/>
        </cfform>
        <!-- InstanceEndEditable -->
        </cfoutput>
    </td>
  </tr>
</table>
</body>
</html>