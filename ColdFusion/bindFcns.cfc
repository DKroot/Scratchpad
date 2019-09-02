<cfcomponent>
    <cffunction name="getXmlData" output="true">
        <cfset var xmlData = "">
        <cffile action="read" file="#expandpath('.')#/states.xml"
            variable="xmlData">
        <cfset xmlData = XmlParse(xmlData)>
        <cfreturn xmlData>
    </cffunction>

    <cffunction name="getstates" access="remote">
        <cfset state = arraynew(2)>
        <cfset xmlData = getXmlData()>
        <cfset numStates = 0>
        <cfset state[1][1] = "0">
        <cfset state[1][2] = "--state--">
        <cfset numStates = ArrayLen(xmlData.states.XmlChildren)>
        <cfloop from="1" to="#numStates#" index="j">
            <cfset state[j+1][1] =
                ltrim(xmlData.states.state[j].XmlAttributes.abr)>
            <cfset state[j+1][2] = ltrim(xmlData.states.state[j].name.xmlText)>
        </cfloop>
        <cfreturn state>
    </cffunction>

    <cffunction name="getcities" access="remote">
        <cfargument name="state" required="yes">
        <cfset var city = arraynew(2)>
        <cfset var xmlData = getXmlData()>
        <cfset var numStates = 0>
        <cfset var numCities = 0>
<cflog text="In getcities">
        <cfset city[1][1] = "0">
        <cfset city[1][2] = "--city--">
        <cftry>
            <cfset numStates = ArrayLen(xmlData.states.XmlChildren)>
            <cfloop from="1" to="#numStates#" index="j">
                <cfif xmlData.states.state[j].XmlAttributes.abr eq state>
                    <cfset numCities =
                        ArrayLen(xmlData.states.state[j].cities.XmlChildren)>
                    <cfloop from="1" to="#numCities#" index="k">
                        <cfset city[k+1][1] =     ltrim(xmlData.states.state[j].cities.city[k].XmlAttributes.name)>
                        <cfset city[k+1][2] = ltrim(xmlData.states.state[j].cities.city[k].XmlAttributes.name)>
                    </cfloop>
                    <cfbreak>
                </cfif>
            </cfloop>
        <cfcatch type="any">
            <!--- Do nothing. --->
        </cfcatch>
        </cftry>
        <cfreturn city>
    </cffunction>

</cfcomponent>