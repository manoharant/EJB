<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*, com.foshanshop.ejb3.bean.*,
				javax.naming.*"%>
<%
	try {
		out.println("�����Ϣ��ӡ��Jboss����̨");
		InitialContext ctx = new InitialContext();
	    EntityLifecycleDAO entitylifecycledao = (EntityLifecycleDAO) ctx.lookup("EntityLifecycleDAOBean/remote");	
		entitylifecycledao.Persist(); //��Ӳ�������
		entitylifecycledao.Load(); //�������� 
		entitylifecycledao.Update(); //�������� 
		
		entitylifecycledao.Remove(); //ɾ�����һ������
		
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>