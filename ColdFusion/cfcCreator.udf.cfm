<cffunction
    name="new"
    access="public"
    returntype="any"
    output="false"
    hint="CFC creator proxy">

    <!--- Return the created component. --->
    <!--- cfreturn CreateObject("component", "components." & arguments[1]) /--->
    <!--- cfinvoke component="#componentPath#" method="init" argumentcollection="#arguments#" returnvariable="result" --->
    <!--- cfreturn new "#componentPath#"(#args#) /--->

    <cfset var componentPath = "components." & arguments[1] />
    <cfset ArrayDeleteAt(arguments, 1) />
    <cfobject name="result" component="#componentPath#" />
    <cfinvoke component="components.Util" method="doesMethodExist" returnvariable="needToInit">
        <cfinvokeargument name="object" value="#result#" />
        <cfinvokeargument name="method" value="init" />
    </cfinvoke>
    <cfif needToInit>
        <cfinvoke component="#result#" method="init" argumentcollection="#arguments#" returnvariable="result">
        <!--- FIXME Need to convert arguments to a structure with names --->
    </cfif>
    <cfreturn result />
</cffunction>