<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*, javax.naming.*, java.util.Properties"%>
<%
		InitialContext ctx = new InitialContext();
		try {
			//ͨ��Զ�̽ӿڵ���EJB
			Operation remote = (Operation) ctx.lookup("OperationBean/remote");
			out.println("<br>(ͨ��Զ�̽ӿڵ���EJB)�ۼӵĽ���ǣ�"+ remote.Addup());
		} catch (Exception e) {
			out.println("<br>Զ�̽ӿڵ���ʧ��");
		}
		out.println("<br>==============================================");
		try {
			//ͨ�����ؽӿڵ���EJB
			LocalOperation local = (LocalOperation) ctx.lookup("OperationBean/local");
			out.println("<br>(ͨ�����ؽӿڵ���EJB)�ۼӵĽ���ǣ�"+ local.Addup());
		} catch (Exception e) {
			out.println("<br>���ؽӿڵ���ʧ��");
		}
%>
