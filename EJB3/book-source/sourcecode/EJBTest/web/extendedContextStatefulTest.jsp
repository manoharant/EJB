<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.ContextDAO,com.foshanshop.ejb3.bean.Context,
				javax.naming.*"%>
				
<%
try {
		InitialContext ctx = new InitialContext();
		ContextDAO extendedStatefuldao = (ContextDAO) ctx.lookup("ExtendedStatefulBean/remote");
		extendedStatefuldao.initdata("����");
		out.println("ʵ��beanĿǰ�Ƿ����й�״̬: <font color=red>"+ extendedStatefuldao.contains()+ "</font>");
		extendedStatefuldao.updateName("��Ϊ");
		Context context = extendedStatefuldao.getContext();
		out.println("<br>���ݿ��е�����Ϊ:"+ context.getName());
} catch (Exception e) {
	out.println(e.getMessage());
}
%>