<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.ContextDAO,com.foshanshop.ejb3.bean.Context,
				javax.naming.*"%>
				
<%
try {
		InitialContext ctx = new InitialContext();
		ContextDAO extendeddao = (ContextDAO) ctx.lookup("ExtendedBean/remote");
		extendeddao.initdata("С��");
		out.println("ʵ��beanĿǰ�Ƿ����й�״̬: <font color=red>"+ extendeddao.contains()+ "</font>");
		extendeddao.updateName("������");
		Context context = extendeddao.getContext();
		out.println("<br>���ݿ��е�����Ϊ:"+ context.getName());
} catch (Exception e) {
	out.println(e.getMessage());
}
%>