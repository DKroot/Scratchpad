enum RoutePath {
  RELEASE_NOTES = "/release-notes"
}

/**
 * Translates a legacy ITAS relative URI to ITASNG. Propagates nulls.
 *
 * Performs all the following translations in this order:
 * 1. `/menu/accessibility.jsp` to `/accessibility.html`
 * 2. `/{folder}/ReleaseNotesSubmitSpring.do` to `/index.html?popup=true#/{RoutePath.RELEASE_NOTES}`
 * 3. `/leavedetailreport.do?{legacy params}` to `/report-popup.html?{params}`
 * 4. `/{root}/` in the URI prefix only to `/index.html?popup=true#/`
 * 5. `.jsp` to ``
 *
 * @param uri
 */
function translate_ITAS_URI(uri: string | null): string | null {
  let result = uri;
  if (result !== null) {
    result = result
        .replace("/menu/accessibility.jsp", "/accessibility.html")
        .replace("/ReleaseNotesSubmitSpring.do", RoutePath.RELEASE_NOTES)
        .replace(/\/leavedetailreport\.do(.+)&payPeri=(\d)&/, "/leavedetailreport.do$1&payPeri=0$2&")
        // TODO EMP is hard-coded for Employee reports for now
        .replace(/\/leavedetailreport\.do\?&rDate=(.+)&payYr=(\d+)&payPeri=(\d+)&emp=(.+)$/,
            "/report-popup.html?ReportType=LEAVE_DETAIL_REPORT&BeginDate=$1&EndDate=$1&selEmp=$4&selPayPeriod=$2$3" +
            "&currentRole=EMP&reportTitle=Leave+Detail+Report")
        .replace(/^\/\w+\//, "/index.html?popup=true#/")
        .replace(".jsp", "");
  }
  console.debug(`Translated URI from \`${uri}\` to \`${result}\``);
  return result;
}

/**
 * Translates all legacy ITAS relative URIs to ITASNG in HTML.
 *
 * Performs translation in the following places:
 * 1. <a href="{uri}">/<a href='{uri}'>
 *
 * @param html
 */
function translate_ITAS_links(html: string | null): string | null {
  let result = html;
  if (result !== null) {
    result = result
        .replace(/<a(.+?)href=(['"])(.+?)(['"])/g,
            (match: string, p1: string, p2: string, p3: string, p4: string, offset: number, s: string) =>
                `<a${p1}href=${p2}${translate_ITAS_URI(p3)}${p4}`);
  }
  console.debug(`Translated links in \`${html}\` to \`${result}\``);
  return result;
}

translate_ITAS_URI(null);
translate_ITAS_URI("https://hr.nih.gov/hr-systems/itas");
translate_ITAS_URI("/menu/accessibility.jsp");
translate_ITAS_URI("/eeDynInfoPages/ReleaseNotesSubmitSpring.do");
translate_ITAS_URI("/leavedetailreport.do?&rDate=02/04/2019&payYr=2019&payPeri=4&emp=HZA3AHAD");
translate_ITAS_URI("/menu/aboutemployeechanges.jsp");

translate_ITAS_links("<a href='https://hr.nih.gov/hr-systems/itas'>");
// noinspection HtmlUnknownTarget
translate_ITAS_links("<a id='my_link' href='/menu/accessibility.jsp'>Link</a>");
translate_ITAS_links(
    `<a href="/leavedetailreport.do?&rDate=01/30/2019&payYr=2019&payPeri=3&emp=HZA3AHAD" target="_blank"`);
translate_ITAS_links(`
    <TD width=35 ALIGN=CENTER><a href="/leavedetailreport.do?&rDate=01/30/2019&payYr=2019&payPeri=3&emp=HZA3AHAD"
        target="_blank"><FONT SIZE=1 FACE=Helvetica COLOR=Blue><STRONG>M</STRONG></a></FONT></TD>
    <TD width=35 ALIGN=CENTER><a href="/leavedetailreport.do?&rDate=01/31/2019&payYr=2019&payPeri=3&emp=HZA3AHAD"
        target="_blank"><FONT SIZE=1 FACE=Helvetica COLOR=Blue><STRONG>M</STRONG></a></FONT></TD>
    <TD width=35 ALIGN=CENTER><a href="/leavedetailreport.do?&rDate=02/01/2019&payYr=2019&payPeri=3&emp=HZA3AHAD"
        target="_blank"><FONT SIZE=1 FACE=Helvetica COLOR=Blue><STRONG>M</STRONG></a></FONT></TD>`);
translate_ITAS_links(`<TD width=35 ALIGN=CENTER><a href="/leavedetailreport.do?&rDate=01/30/2019&payYr=2019&payPeri=3&emp=HZA3AHAD" target="_blank"><FONT SIZE=1 FACE=Helvetica COLOR=Blue><STRONG>M</STRONG></a></FONT></TD> <TD width=35 ALIGN=CENTER><a href="/leavedetailreport.do?&rDate=01/31/2019&payYr=2019&payPeri=3&emp=HZA3AHAD" target="_blank"><FONT SIZE=1 FACE=Helvetica COLOR=Blue><STRONG>M</STRONG></a></FONT></TD> <TD width=35 ALIGN=CENTER><a href="/leavedetailreport.do?&rDate=02/01/2019&payYr=2019&payPeri=3&emp=HZA3AHAD" target="_blank"><FONT SIZE=1 FACE=Helvetica COLOR=Blue><STRONG>M</STRONG></a></FONT></TD>`);
