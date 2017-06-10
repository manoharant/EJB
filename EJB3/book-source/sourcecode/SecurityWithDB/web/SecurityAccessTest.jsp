<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.SecurityAccess,
				javax.naming.*,
				java.util.*"%>
<%
	Properties props = new Properties();
	props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
	props.setProperty(Context.PROVIDER_URL, "localhost:1099");
	props.setProperty(Context.SECURITY_PRINCIPAL, "");
	props.setProperty(Context.SECURITY_CREDENTIALS, "");
	String user = request.getParameter("user");
	String pwd = request.getParameter("pwd");
	if (user!=null && !"".equals(user.trim())){
		props.setProperty(Context.SECURITY_PRINCIPAL, user);
		props.setProperty(Context.SECURITY_CREDENTIALS, pwd);
	}
	InitialContext ctx = new InitialContext(props);
	SecurityAccess securityaccess = (SecurityAccess) ctx.lookup("SecurityAccessBean/remote");
	try{				
		out.println("<font color=green>Login:</font>"+ securityaccess.AdminUserMethod()+ "<br>");
	}catch(Exception e){
		out.println(user+ "Exception AdminUserMethod<BR>");
	}

	out.println("==========================<BR>");
	try{
		out.println("<font color=green>Login:</font>"+ securityaccess.DepartmentUserMethod()+ "<br>");
	}catch(Exception e){
		out.println(user+ "DepartmentUserMethod");
	}

	out.println("==========================<BR>");
	try{
		out.println("<font color=green>Login:</font>"+ securityaccess.AnonymousUserMethod()+ "<br>");
	}catch(Exception e){
		out.println(user+ "AnonymousUserMethod");
	}	
%>

<html>
  <head>
    <title>Login</title>
  </head>

  <body>
    <center><h2>Test</h2></center>
    <br />
    Testing security
    <br />
    <form method="POST" action="SecurityAccessTest.jsp">
       Username: <input type="text" name="user"/>
       <br />
       Password: <input type="password" name="pwd"/>
       <br />
       <input type="submit" value="身份验证"/>
    </form>
   <p>usename<STRONG>lihuoming</STRONG>&nbsp;&nbsp;password: <STRONG>123456</STRONG>    </p> 
	<p>  username: <STRONG>zhangfeng</STRONG>&nbsp;&nbsp;password <STRONG>111111</STRONG></p>
	<p>  username: <STRONG>wuxiao</STRONG>&nbsp;&nbsp;password <STRONG>123</STRONG></p>
  </body>
</html>