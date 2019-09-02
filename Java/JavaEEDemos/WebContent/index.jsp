<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<%!
void tee(JspWriter out, String s) throws IOException {
    out.println(s);
    System.out.println("[RequestInfo] " + s);
}
%>
<html>
<head>
<title>JavaEE 6 Demos</title>
</head>
<body>
<h2>Demos</h2>
  <ul>
    <li><a href="faces/facelet-templates/index.xhtml">Facelet Templates</a></li>
  </ul>

<h2>Request Information</h2>
  <h3><% tee(out, ">> Request " + request.getRequestURL()); %></h3>
  <h3><% tee(out, ">Client"); %></h3>
  <pre><%= request.getRemoteHost() %> ( <%= request.getRemoteAddr() %> )</pre>

  <h3><% tee(out, ">Headers"); %></h3>
  <pre>
<%
    for (String header : Collections.list(request.getHeaderNames())) {
        tee(out, header + "=" + request.getHeader(header));
    }
%>
  </pre>
  <h3><% tee(out, ">Content: MIME=" + request.getContentType() + " size=" + request.getContentLength()); %></h3>
  <pre>
<%
    if (request.getContentLength() > 0) {
        BufferedReader br = request.getReader();
        String line;
        while ((line = br.readLine()) != null) {
            tee(out, line);
        }
    }
%>
  </pre>
</body>
</html>