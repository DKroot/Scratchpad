<cfscript>
  var x = Now();
  
  // False parser error: https://bugbase.adobe.com/index.cfm?event=bug&id=2840065
  param name="url.foo" default=Now();
  
  var u = new Util();
</cfscript>