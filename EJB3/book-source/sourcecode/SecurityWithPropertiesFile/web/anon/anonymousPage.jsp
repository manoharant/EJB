<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.SecurityAccess,
				javax.naming.*,
				org.jboss.security.*,
				java.util.*"%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <title>Jaas tests</title>
</head>

<body>
<H3>Jaas Tests</H3>
<P>
	这个页面允许匿名用户访问:<br>
<%
  InitialContext ctx = new InitialContext();
  SecurityAccess securityaccess = (SecurityAccess) ctx.lookup("SecurityAccessBean/remote");
   try{
	out.println("<font color=green>调用结果:</font>"+ securityaccess.AnonymousUserMethod()+ "<br>");
   }catch(Exception e){
	out.println("访问AnonymousUserMethod方法出错");
   }
%>
</P>
</body>
</html>