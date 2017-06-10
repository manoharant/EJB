<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.MultitableMappingDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*"%>
<%
try {
	InitialContext ctx = new InitialContext();
	MultitableMappingDAO dao = (MultitableMappingDAO) ctx.lookup("MultitableMappingDAOBean/remote");
	MainTable mainTable = new MainTable();
	mainTable.setName("���O");
	mainTable.setAddress("������ƽ��һ��");
	mainTable.setPostcode("100081");
	dao.save(mainTable);
	List<MainTable> mainTables = dao.getMainTables();
	for(MainTable mt : mainTables){
		out.println(mt+ "<br>");
	}
} catch (Exception e) {
	out.println(e.getMessage());
}
%>