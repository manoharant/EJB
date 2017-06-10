<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.Injection, javax.naming.*,com.foshanshop.conf.Constants"%>
<%
		try {
		    InitialContext ctx = Constants.getInitialContext();
			Injection injection = (Injection) ctx.lookup("InjectionBean/remote");
			out.println(injection.SayHello());
		} catch (NamingException e) {
			out.println(e.getMessage());
		}
%>
