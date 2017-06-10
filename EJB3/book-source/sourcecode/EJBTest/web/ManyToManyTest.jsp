<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.foshanshop.ejb3.TeacherDAO,com.foshanshop.ejb3.bean.*,
				javax.naming.*, 
				java.util.*"%>
<%
	try {
		InitialContext ctx = new InitialContext();
		TeacherDAO teacherdao = (TeacherDAO) ctx.lookup("TeacherDAOBean/remote");
		Teacher newteacher = new Teacher("��Ϊ");
		newteacher.addStudent(new Student("Ҷ����"));
		newteacher.addStudent(new Student("�¹���"));
		teacherdao.insertTeacher(newteacher);
		
		List<Teacher> teachers = teacherdao.getAllTeacher();
		for(Teacher teacher : teachers){
			out.println("======= ��ȡ���Ϊ1����ʦ������"+ teacher.getTeacherName() +" ======<br>");
			for(Student student : teacher.getStudents()){
				out.println("&nbsp;&nbsp;����ѧ��:"+ student.getStudentName() +"<br>");
			}
		}
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>