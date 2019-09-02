<%@ page isErrorPage="true" buffer="64kb"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<%@ page import="org.apache.commons.lang.*"%>
<%@ page import="org.apache.struts.*"%>

<%@ page import="gov.nih.era.facts.util.*"%>

<tiles:insert definition="facts.sd.login.logout">
  <tiles:put name="pageTitle" value="FACTS System Error" />
  <tiles:put name="sd_content1" type="string">
    <%
        try {
                    pageContext.setAttribute("occurredAt", new Date());
                    Throwable e = (Throwable) request.getAttribute("javax.servlet.error.exception");
                    String[] errorDetails = null;
                    if (e != null) {
                        StringWriter stackTrace = null;
                        stackTrace = new StringWriter();
                        e.printStackTrace(new PrintWriter(stackTrace));
                        errorDetails = stackTrace.toString().split("\\n");
                    }
                    pageContext.setAttribute("errorDetails", errorDetails);

                    StringBuilder requestedUrl = new StringBuilder();
                    if (request.getAttribute("javax.servlet.forward.request_uri") == null) {
                        requestedUrl.append("N/A");
                        //TODO The original request URL is not available in Struts ERROR redirect (in 1.2.x?)
                        //pageContext.setAttribute("requestedUrl", request.getAttribute(Globals.ORIGINAL_URI_KEY));
                        //Struts 1.3+
                    } else {
                        requestedUrl =
                                requestedUrl.append(request.getScheme()).append("://").append(
                                        request.getServerName()).append(":").append(request.getServerPort()).append(
                                        (String) request.getAttribute("javax.servlet.forward.request_uri"));
                        if (StringUtils.trimToNull((String) request.getAttribute("javax.servlet.forward.query_string")) != null) {
                            requestedUrl.append("?").append(
                                    request.getAttribute("javax.servlet.forward.query_string"));
                        }
                    }
                    pageContext.setAttribute("requestedUrl", requestedUrl);

                    // == eRA-specific context ==
                    pageContext.setAttribute("loggedIn", AccessControlHelper.isLoggedIn(request));
                    pageContext.setAttribute("userFullName", AccessControlHelper.getUserFullName(request));
                    pageContext.setAttribute("userID", AccessControlHelper.getFullID(request));

                    // == FACTS-specific context ==
                    pageContext.setAttribute("isSdUser", request.isUserInRole("MANAGE_SDCR_STATE_PRIV"));
    %>
    <div id="content">
      <form action="mailto:korobskd@mail.nih.gov" method="get">
        <input type="hidden" name="subject" value="FACTS Error Report">
        <table width="100%" border="0" align="center" style="padding: 10px;">
          <tr>
            <td align="left">
              <p class="error-redtxt">A system error occurred. Contact eRA Helpdesk.</p>

              <p>The project team is sorry that you ran into this problem. Please logout, close the browser and
                repeat the steps that you tried to do. If you continue to have this problem, please submit an error
                report. The support team will get all the technical details necessary for troubleshooting and get back
                to you as soon as possible.</p> <%--
                <p>Describe the exact sequence of steps that led to this error. Be brief, but specific. Include
                all specific data entered. The following is an example of a good sequence:</p>
                <p>1. SDC Search and Hitlist Screen<br />
                2. Select Country: = Ukraine<br />
                3. Search<br />
                3. Process for Clearance ID 19875<br />
                4. Enter Action Comments = This is a great SDCR!<br />
                5. Approve<br />

                <div align="center">
                  <p><b>Steps, reproducing ths problem</b></p>
                  <textarea cols="80" rows="15" name="usertext">Please enter steps that reproduce this problem</textarea>
                </div>
                --%>
            </td>
          </tr>
          <%--
          <tr>
            <td align="center"><input type="image" name="submit" src="images/submit_bt.gif"
                        alt="Submit" width="88" height="24" /></td>
          </tr>
          --%>
          <tr>
            <td>Technical Details:<%-- to be included in the report:--%><c:choose>
                <c:when test="${loggedIn}">
                  <ul class="error-list">
                    <li><b>Error: </b> <html:errors header="errors.sd.header" footer="errors.sd.footer"
                        prefix="errors.sd.prefix" suffix="errors.sd.suffix" /> <c:if test="${not empty errorDetails}">
                        <div class="alert_style color_red">
                          <pre><html:img alt="Alert" page="/images/alert_icon.png" /> <c:forEach var="line"
                              items="${errorDetails}">${line}
</c:forEach></pre>
                          <%-- %=WordUtils.wrap(
                                                StringEscapeUtils.escapeHtml((String) pageContext.getAttribute("line")),
                                                200, null, true) --%>
                        </div>
                      </c:if></li>

                    <li><b>Requested page:</b> ${requestedUrl}</li>
                    <%--
                  <li><b>Form:</b><if form submitted:><br></if>
                    <pre><loop through the form>#item# = #HTMLEditFormat(Wrap(item), 120) )##chr(10)#</loop></pre>
                  </li>
                  --%>
                    <li><b>Previous page:</b> ${empty header['Referer'] ? "N/A" : header["Referer"]}</li>

                    <li><b>User:</b> ${userFullName} (${userID})</li>

                    <li><b>Is State Department User:</b> ${isSdUser}</li>

                    <li><b>Browser:</b> ${header['user-agent']}</li>

                    <li><b>Error occurred at:</b> <fmt:formatDate value="${occurredAt}"
                        pattern="yyyy-MM-dd HH:mm:ss" /></li>
                  </ul>
                </c:when>
                <c:otherwise>
                You are not logged in. No technical details are available for this error.
              </c:otherwise>
              </c:choose>
            </td>
          </tr>
        </table>
      </form>
      <%
          // In case there is a runtime error in the error page: simplify output
                  } catch (Throwable e) {
                      StringWriter stackTrace = new StringWriter();
                      e.printStackTrace(new PrintWriter(stackTrace));
      %>
      <div class="alert_style color_red">
        <pre>
          <html:img alt="Alert" page="/images/alert_icon.png" /> <%=stackTrace%></pre>
      </div>
      <%
          }
      %>
    </div>
  </tiles:put>
</tiles:insert>