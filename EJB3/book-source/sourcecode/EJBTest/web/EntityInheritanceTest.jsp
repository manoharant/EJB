<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*, com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*"%>
<%
	try {
		InitialContext ctx = new InitialContext();
	    EntityInheritanceDAO entityinheritancedao = (EntityInheritanceDAO) ctx.lookup("EntityInheritanceDAOBean/remote");			
		entityinheritancedao.initializeData();
		out.println("==================Vehicle��Ķ�����================<br>");
		for(Vehicle vehicle : entityinheritancedao.getVehicle()){
			out.println("ID="+ vehicle.getId() +"<br>");
		}
		out.println("==================Car��Ķ�����====================<br>");
		for(Car car : entityinheritancedao.getCar()){
			out.println("ID="+ car.getId() +"<br>");
		}
		out.println("==================Camion��Ķ�����=================<br>");
		for(Camion camion : entityinheritancedao.getCamion()){
			out.println("ID="+ camion.getId() +"<br>");
		}
		/* ��������ɾ�����м�¼
           entityinheritancedao.deleteVehicle();
		*/
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>