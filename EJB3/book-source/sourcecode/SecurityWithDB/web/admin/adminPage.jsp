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
	���ҳ��ֻ�������Ա��ɫ����:<br>
<%
  InitialContext ctx = new InitialContext();
  SecurityAccess securityaccess = (SecurityAccess) ctx.lookup("SecurityAccessBean/remote");
  try{				
	out.println("<font color=green>���ý��:</font>"+ securityaccess.AdminUserMethod()+ "<br>");
  }catch(Exception e){
		out.println("����AdminUserMethod��������");
  }
%>
</P>
</body>
</html>