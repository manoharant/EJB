<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*, javax.naming.*"%>
<%
	try {		
		/**
	     * ��Ϊһ����ҵӦ�÷�����Web�ͻ�����õ���EJB�ı��ؽӿڡ�Ҫ���ñ��ؽӿڣ�������Ҫ��web.xml�У�
		 * ��HelloWorld�ı�������ע���JNDI ENC��Ȼ��ͨ��ע���ENC���Ʋ��ұ��ؽӿڡ����£�
	     */
	     InitialContext ctx = new InitialContext();
	     HelloWorldLocal local = (HelloWorldLocal) ctx.lookup("java:comp/env/ejb/HelloWorldLocal");
	     out.println(local.SayHello("������"));
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>
