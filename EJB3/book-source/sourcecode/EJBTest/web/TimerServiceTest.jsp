<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*, javax.naming.*"%>
<%
	try {
		InitialContext ctx = new InitialContext();
		TimerServiceDAO timer = (TimerServiceDAO) ctx.lookup("TimerServiceBean/remote");
		timer.scheduleTimer((long)3000);
		out.println("��ʱ���Ѿ���������۲�Jboss����̨����������ʱ������5�Σ�����ֹ��ʱ��");
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>