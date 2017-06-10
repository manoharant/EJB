<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.*,com.foshanshop.ejb3.bean.*,
				javax.naming.*, java.util.Date, java.util.List"%>

<TABLE width="80%" border="1">
<TR bgcolor="#DFDFDF">
	<TD>personid</TD>
	<TD>name</TD>
	<TD>sex</TD>
	<TD>age</TD>
	<TD>birthday</TD>
</TR>
<%
try {
		InitialContext ctx = new InitialContext();
		PersonDAOLocal persondao = (PersonDAOLocal) ctx.lookup("java:comp/env/ejb/PersonDAOLocal");
		Person newperson = new Person();
		newperson.setName("����");
		newperson.setAge((short)27);
		newperson.setBirthday(new Date());
		newperson.setSex(true);
		persondao.insertPerson(newperson);
		
		List<Person> persons = persondao.getPersonList();
		for(Person person : persons){
			out.println("<TR><TD>"+ person.getPersonid()+"</TD><TD>"+ person.getName()+"</TD><TD>"+ person.getSex()+"</TD><TD>"+ person.getAge()+"</TD><TD>"+ person.getBirthday()+"</TD></TR>");
        }

} catch (Exception e) {
	out.println(e.getMessage());
}
%>
</TABLE>