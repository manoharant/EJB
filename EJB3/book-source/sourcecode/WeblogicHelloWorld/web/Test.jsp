<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*, javax.naming.*"%>
<%
	try {		
		/**
	     * 作为一个企业应用发布，Web客户端最好调用EJB的本地接口。要调用本地接口，我们需要在web.xml中，
		 * 把HelloWorld的本地引用注册进JNDI ENC，然后通过注册的ENC名称查找本地接口。如下：
	     */
	     InitialContext ctx = new InitialContext();
	     HelloWorldLocal local = (HelloWorldLocal) ctx.lookup("java:comp/env/ejb/HelloWorldLocal");
	     out.println(local.SayHello("本地人"));
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>
