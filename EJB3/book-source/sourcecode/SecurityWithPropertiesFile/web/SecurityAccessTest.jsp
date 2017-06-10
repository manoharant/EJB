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
		out.println("<font color=green>调用结果:</font>"+ securityaccess.AdminUserMethod()+ "<br>");
	}catch(Exception e){
		out.println(user+ "没有权限访问AdminUserMethod方法<BR>");
	}

	out.println("==========================<BR>");
	try{
		out.println("<font color=green>调用结果:</font>"+ securityaccess.DepartmentUserMethod()+ "<br>");
	}catch(Exception e){
		out.println(user+ "没有权限访问DepartmentUserMethod方法<BR>");
	}

	out.println("==========================<BR>");
	try{
		out.println("<font color=green>调用结果:</font>"+ securityaccess.AnonymousUserMethod()+ "<br>");
	}catch(Exception e){
		out.println(user+ "没有权限访问AnonymousUserMethod方法<BR>");
	}	
%>

<html>
  <head>
    <title>安全访问测试</title>
  </head>

  <body>
    <center><h2>安全访问测试</h2></center>
    <br />
    请输入你的用户名及密码
    <br />
    <form method="POST" action="SecurityAccessTest.jsp">
       Username: <input type="text" name="user"/>
       <br />
       Password: <input type="password" name="pwd"/>
       <br />
       <input type="submit" value="身份验证"/>
    </form>
    <p>
      管理员  用户名: <STRONG>lihuoming</STRONG>&nbsp;&nbsp;密码: <STRONG>123456</STRONG>
    </p>
    <p>事业部  用户名: <STRONG>zhangfeng</STRONG>&nbsp;&nbsp;密码 <STRONG>111111</STRONG></p>
	<p>合作伙伴  用户名: <STRONG>wuxiao</STRONG>&nbsp;&nbsp;密码 <STRONG>123</STRONG></p>
  </body>
</html>