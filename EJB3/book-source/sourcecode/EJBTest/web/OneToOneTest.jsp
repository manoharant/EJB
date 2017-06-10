<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.OneToOneDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*,
				java.text.SimpleDateFormat,
				java.util.*"%>
<%
	try {
		InitialContext ctx = new InitialContext();
		String outformate = "<font color=blue>CMD>>Out>></font> ";
		OneToOneDAO oneToonedao = (OneToOneDAO) ctx.lookup("OneToOneDAOBean/remote");
		SimpleDateFormat formatter = new SimpleDateFormat("MMddhhmmss");
		String endno = formatter.format(new Date()).toString();
        Person newperson = new Person();
        newperson.setName("Ҷ����");
        newperson.setSex(true);
        newperson.setAge((short)26);
        newperson.setBirthday(new Date());
        IDCard idcard = new IDCard("44011"+endno);
        idcard.setPerson(newperson);
        newperson.setIdcard(idcard);
		oneToonedao.insertPerson(newperson);
		//���ʱ��ע�⣬���֤�Ų�Ҫ�ظ�����Ϊ���ݿ��ֶ����֤����Ψһ��
		Person person = oneToonedao.getPersonByID(new Integer(1)); 
		if (person!=null){
			out.println(outformate +"Ѱ�ұ��Ϊ1����Ա<br>");
			out.println("����:"+ person.getName() +" ���֤��"+ person.getIdcard().getCardno() +"<br>");
		}else{
			out.println("û���ҵ����Ϊ1����Ա<br>");
		}
		out.println(outformate +"���±��Ϊ1����Ա������Ϊ����,���֤��Ϊ33012" +endno +"<br>");
		oneToonedao.updatePersonInfo(new Integer(1), "����", "33012" +endno);			
		
		out.println("================ɾ�����Ϊ3����Ա==============<br>");	
		oneToonedao.deletePerson(new Integer(3));
		
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>