<!---
    Generic utility functions
        "Static" component (no instance variables)
--->
<cfcomponent hint="Generic utility functions">

    <cfscript>
        /**
        * Compares amount with the limit rounding to 1 cent precision
        *
        * @param amount
        * @param limit
        */

        boolean function isAmountGreater(required numeric amount, required numeric limit) {
            return (amount - limit >= 0.005);
        }

        /**
        * Formats timestamps
        *
        * @param timeStamp A Date-time
        */

        string function dateTimeFormat(required timeStamp) {
            if(timeStamp == "") {
                return "";
            } else {
                return LSDateFormat(timeStamp) & " " & LSTimeFormat(timeStamp);
            }
        }

        /**
        * Formats currency amount
        *
        * @param amount numeric or currency value
        * @returns      original value if not a valid currency
        */

        string function currencyFormat(required amount) {
            if(amount != "" && LSIsCurrency(amount)) {
                var numericValue = LSParseCurrency(amount);
                return LSCurrencyFormat(numericValue, 'none');// currency format works correctly only on numerics
            } else {
                return amount;
            }
        }

        /**
        * Get a parent of a slash-separated path. Trailing slash is not included in the result.
        */

        string function parentPath(required string path) {
            var lastPosition = ListLen(path, "/");
            return ListDeleteAt(path, lastPosition, "/");
        }

        /**
        * Customized Wrap() function
        * Differences from CF Wrap(strip=false):
        *   1. Does not trim leading spaces
        *   2. Does not insert ending break when input is wrapped
        */

        string function betterWrap(required string s, required numeric limit, boolean wordWrap=true) {
            var javaSystem = CreateObject("java", "java.lang.System");
            var eol = javaSystem.getProperty("line.separator");
            var result = "";

            for(var line in ListToArray(s, eol)) {// wrap each input line
                while(Len(line) > 0) {
                    if(Len(line) <= limit) {
                        result &= RTrim(line);
                        break;
                    } else {// wrap
                        if(wordWrap) {
                            var wrapPos = Min(limit, limit - REFind("\s", Reverse(Left(line, limit))) + 1);
                        } else {
                            var wrapPos = limit;
                        }
                        // add wrapped line to result
                        result &= RTrim(Left(line, wrapPos)) & eol;

                        // process the rest of the line
                        line = RemoveChars(line, 1, wrapPos);
                    }
                }
            }

            return result;
        }

        /**
        * Returns Fiscal Year of the date
        */

        numeric function USGovFiscalYear(date d=Now()) {
            if(10 <= Month(d)) {
                return Year(d) + 1;
            } else {
                return Year(d);
            }
        }

        /**
        * Return a request URL with an updated query parameter value
        *
        * @param
        */

        string function updateURLParam(required string name, required string value) {
            var result = GetPageContext().GetRequest().getRequestURL();
            var q = Duplicate(URL);
            q[name] = value;// do not modify URL scope directly: unwanted side-effect
            var separator = "?";
            for(var param in q) {
                result &= separator & param & "=" & q[param];
                separator = "&";
            }
            return result;
        }

        /**
        * Add a parameter to a URL
        *
        * @param
        */

        string function addURLParam(required string url, required string param) {
            if(param == "") {
                return url;
            }
            if(Find("?", url) == 0) {
                return url & "?" & param;
            } else {
                return url & "&" & param;
            }
        }

        /**
        * Output query results to CSV
        * Preserves leading zeros for Excel imports
        * Outputs only date component for dates
        *
        * @param q            query
        * @param headers    A list of headers for the first row. Defaults to all column names.
        * @param columns     The columns to output. Defaults to all the query columns.
        */

        void function writeToCSV(required query q, string headers, string columns) {
            var EOL = chr(13) & chr(10);
            param name="arguments.headers" default=q.columnlist;
            param name="arguments.columns" default=q.columnlist;

            var headerArray = ListToArray(headers);
            var colArray = ListToArray(columns);

            var i = 0;
            for(header in headerArray) {
                i++;
                if(1 < i) {
                    WriteOutput(",");
                }
                WriteOutput('"' & header & '"');
            }
            WriteOutput(EOL);

            for(i = 1; i <= q.RecordCount; i++) {
                var j = 0;
                for(column in colArray) {
                    j++;
                    if(1 < j) {
                        WriteOutput(",");
                    }

                    value = q[column][i];
                    if(IsDate(value)) {
                        value = DateFormat(value, "yyyy-mm-dd");
                    }
                    if(IsNumeric(value) && Left(value, 1) == "0") {
                        // Preserve leading zeros for Excel: output "=""08075"""
                        value = '=""#value#""';
                    }

                    WriteOutput('"' & value & '"');
                }
                WriteOutput(EOL);
            }
        }

        /**
        * Abbreviate text and provide link to the full text
        *
        * @param
        */

        string function abbreviate(required string text, required numeric maxLength, string fullVersionURL) {
            if(Len(text) <= maxLength) {
                return text;
            } else {
                var abbreviatedText = Left(text, maxLength - 3) & "...";
                if(IsDefined("arguments.fullVersionURL")) {
                    return '<a href="' & fullVersionURL & '" class="link1" title="' & HTMLEditFormat(text) & '">' & HTMLEditFormat(abbreviatedText)
                & '</a>';
                } else {
                    return HTMLEditFormat(abbreviatedText);
                }
            }
        }

        /**
        * Generate a text + hidden input or a drop-down based on a number of data items
        *
        * @param inputName          a name for generated input
        * @param list               list of display items = values
        * @param selectedValue      currently selected value
        * @param emptyListDisplay   a value to display when data is empty
        * @param includeBlank       include blank value in a drop-down
        * @param enabled            is control enabled?
        */

        void function listToInput(required string inputName, required string list, string selectedValue="",
                                  string emptyListDisplay="",boolean includeBlank=true, boolean enabled=true) {
            if(ListLen(list) == 0) {
                WriteOutput('<input type="hidden" name="#inputName#" value="" />');
                WriteOutput('#emptyListDisplay#');
            } else if(ListLen(list) == 1) {
                WriteOutput('<input type="hidden" name="#inputName#" value="#list#" />');
                WriteOutput('#list#');
            } else {
                WriteOutput('<select name="#inputName#" style="width:auto"');
                if(!enabled) {
                    WriteOutput(' disabled="disabled"');
                }
                WriteOutput('>');
                if(includeBlank) {
                    WriteOutput('<option value=""></option>');
                }
                var listValues = ListToArray(list);
                for(var value in listValues) {
                    WriteOutput('<option value="#value#"');
                    if(value == selectedValue) {
                        WriteOutput('selected="selected"');
                    }
                    WriteOutput('>#value#</option>');
                }
                WriteOutput('</select>');
            }
        }

        /**
        * Generate a text + hidden input or a drop-down based on a number of data items
        * Drop-down is sorted by display values
        *
        * @param inputName       a name for generated input
        * @param data            struct of { value = display item, ...}
        * @param selectedValue   currently selected value
        * @param emptyDisplay    a value to display when data is empty
        * @param includeBlank    include blank value in a drop-down
        * @param enabled         is control enabled?
        */

        void function structToInput(required string inputName, required struct data, string selectedValue="",
                                    string emptyDisplay="",boolean includeBlank=true, boolean enabled=true) {
            if(StructIsEmpty(data)) {
                WriteOutput('<input type="hidden" name="#inputName#" value="" />');
                WriteOutput('#emptyDisplay#');
            } else if(StructCount(data) == 1) {
                WriteOutput('<input type="hidden" name="#inputName#" value="#StructKeyList(data)#" />');
                WriteOutput('#data[StructKeyList(data)]#');
            } else {
                WriteOutput('<select name="#inputName#" style="width:auto"');
                if(!enabled) {
                    WriteOutput(' disabled="disabled"');
                }
                WriteOutput('>');
                if(includeBlank) {
                    WriteOutput('<option value=""></option>');
                }

                var keys = StructSort(data);
                for(var key in keys) {
                    WriteOutput('<option value="#key#"');
                    if(key == selectedValue) {
                        WriteOutput('selected="selected"');
                    }
                    WriteOutput('>#data[key]#</option>');
                }
                WriteOutput('</select>');
            }
        }

        /**
        * Does a method with a certain name exists in an object?
        *
        * @param object
        * @param method
        */

        boolean function doesMethodExist(required any object, required string method) {
            var metadata = getMetadata(object);
            for(var i = 1; i <= ArrayLen(metadata.functions); i++) {
                var f = metadata.functions[i];
                if(f.name == method) {
                    return true;
                }
            }

            /* TBD the code below blows up (9.0.1), unclear why
            for (var f in metadata.functions) {
                if (f.name == method) {
                    return true;
                }
            }
            */
            return false;
        }

    </cfscript>

    <cffunction name="removeCookie">
        <cfargument name="name" required="yes" type="string"/>

        <cfcookie name="#arguments.name#" expires="now">
    </cffunction>

</cfcomponent>