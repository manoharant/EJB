<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*, javax.naming.*"%>
<%

	try {
		LifeCycle lifecycle = (LifeCycle) session.getAttribute("lifecycle");
		if (lifecycle == null) {
		  InitialContext ctx = new InitialContext();
		  lifecycle = (LifeCycle) ctx.lookup("LifeCycleBean/remote");
		  session.setAttribute ("lifecycle", lifecycle);
		}
		out.println(lifecycle.Say());
		out.println("<BR>��ע��۲�Jboss����̨���.�ȴ�10����,��������ۻ��˻ỰBean,@PrePassivateע�͵ķ�������ִ��<BR>");			
		out.println("<font color=red>����Ե���stopSession�����ѻỰBeanʵ��ɾ������ɾ���ỰBeanʱ��������@PreDestroy�¼�<BR></font>");	
		/*
		lifecycle.stopSession();
		*/
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>
