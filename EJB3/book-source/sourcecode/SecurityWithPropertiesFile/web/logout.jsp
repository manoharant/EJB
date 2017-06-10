<%@ page contentType="text/html; charset=GBK"
    import="java.util.*,javax.naming.*, javax.servlet.http.*, org.jboss.security.*"%>

<%
      ((HttpSession) request.getSession()).invalidate ();
      SecurityAssociation.clear ();
%>
<html>
<head>
<META HTTP-EQUIV="Refresh" CONTENT="1;URL=http:index.jsp">
</head>  
  <body>
    ีýิฺอหณ๖ตวยผ...<br>
  </body>
</html>