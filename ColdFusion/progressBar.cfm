<html>
<head>
<title>Progress Bar</title>

<script type="text/javascript">
// The function that starts the progress bar,
// called when the user clicks the Send comment button.
function startProgress() {
    ColdFusion.ProgressBar.start("mydataProgressbar");
};

// The function called when the progress bar finishes,
// specified by the cfprogressbar tag onComplete attribute.
function onfinish() {
    alert("Done");
};
</script>

</head>
<body>
<h2>Let's show some progres!</h2>
<cfscript>
    application.webApp = RemoveChars(application.Util.parentPath(CGI.SCRIPT_NAME), 1, 1);
</cfscript>

<!--- Ensure there is no Session.STATUS value, which is used by
the progress bar bind CFC, when the page displays. --->
<cfif IsDefined("Session.STATUS")>
  <cfscript>
      StructDelete(Session,"STATUS");
  </cfscript>
</cfif>

<!--- For code simplicity, formatting is minimal. --->
<cfform name="kitform">
  <p>To make our service better and to benefit from our special offers,
    take a moment to give us your email address and send us a comment.</p>
  <p>Name:<br />
      &nbsp;<cfinput type="text" name="name">  </p>
  <p>E-mail:<br />
      &nbsp;<cfinput type="text"  name="email">  </p>
  <p>Comment:<br />
      &nbsp;<cftextarea   name="cmnt"/></p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <cfinput type="button" name="" value="Send Comment" onClick=startProgress()></p>
  <!--- The progressbar control --->
  <div style="padding-left:3px" >
    <cfprogressbar name="mydataProgressbar"
          bind="cfc:#application.webApp#.Progress.getstatus()"
          interval="1700"
          width="200"
          oncomplete="onfinish"/>
  </div>

</cfform>
</body>
</html>