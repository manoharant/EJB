<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.ContextDAO,com.foshanshop.ejb3.bean.Context,
				javax.naming.*"%>
				
<%
try {
		InitialContext ctx = new InitialContext();
		ContextDAO transactionScopeddao = (ContextDAO) ctx.lookup("TransactionScopedBean/remote");
		transactionScopeddao.initdata("С��");
		out.println("ʵ��beanĿǰ�Ƿ����й�״̬: <font color=red>"+ transactionScopeddao.contains()+ "</font>");
		transactionScopeddao.updateName("����");
		Context context = transactionScopeddao.getContext();
		out.println("<br>���ݿ��е�����Ϊ:"+ context.getName());
} catch (Exception e) {
	out.println(e.getMessage());
}
%>