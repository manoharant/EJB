<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*,java.util.*,javax.naming.*"%>
<%
	try {
		InitialContext ctx = new InitialContext();
		Cart cat = (Cart)session.getAttribute("cat");
		if(cat==null){//����һ�����ﳵ
			cat = (Cart) ctx.lookup("CartBean/remote");
			session.setAttribute("cat", cat);
		}
		cat.AddBuyItem("��EJB3.0ʵ���̡̳�");
		List<String> buyitem = cat.getBuyItem();
		out.println("���ﳵ����Ʒ�б�<br>");
		for(String name : buyitem){
			out.println("  "+ name+ "<br>");
		}		
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>
