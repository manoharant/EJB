<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.HelloWorld, javax.naming.*, com.foshanshop.conf.Constants"%>
<%
		try {
			InitialContext ctx = Constants.getInitialContext();
			HelloWorld helloworld = (HelloWorld) ctx.lookup("HelloWorldBean/remote");
			out.println(helloworld.SayHello("·ðÉ½ÈË"));
		} catch (NamingException e) {
			out.println(e.getMessage());
		}
%>
