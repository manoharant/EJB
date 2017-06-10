<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.AirLineDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*"%>
<%	
	try {
		InitialContext ctx = new InitialContext();
		AirLineDAO airlinedao = (AirLineDAO) ctx.lookup("AirLineDAOBean/remote");
		airlinedao.insertAirLine();

		AirLine airLine = airlinedao.getAirLineByID("PEK","CAN"); 
		out.println("���ߣ�"+ airLine.getId().getLeavecity() +"--"+ airLine.getId().getArrivecity() +"<br>");
		out.println("============== �������º��� =================<br>");
		if (airLine!=null){
	        for(Flight flight : airLine.getFlights()){
	        	out.println("����:"+ flight.getFlightno() +"<br>");
	        }
		}else{
			out.println("û���ҵ���غ���");
		}
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>