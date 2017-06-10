<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.OrderDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*"%>
<%
	try {			
		InitialContext ctx = new InitialContext();
		OrderDAO orderdao = (OrderDAO) ctx.lookup("OrderDAOBean/remote");
        Order neworder = new Order();
        neworder.setCreatedate(new Date());
        neworder.addOrderItem(new OrderItem("�ʼǱ�����", new Float(13200.5)));
        neworder.addOrderItem(new OrderItem("U��", new Float(620)));
        neworder.setAmount(new Float(13200.5+620));
		orderdao.insertOrder(neworder);
        List<Order> list = orderdao.getAllOrder();
        for(Order od : list){
			out.println("==============�����ţ�"+ od.getOrderid() +"=================<br>");
			for(OrderItem item : od.getOrderItems()){
				out.println("������Ʒ:"+ item.getProductname() +"<br>");
			}
        }
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>