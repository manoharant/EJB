package junit.test;

import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.TeacherDAO;
import com.foshanshop.ejb3.bean.Student;
import com.foshanshop.ejb3.bean.Teacher;

public class TeacherDAOTest {
    private static TeacherDAO dao;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Properties props = new Properties();        
        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.provider.url", "localhost:1099");
        props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        InitialContext ctx = new InitialContext(props);
        dao = (TeacherDAO) ctx.lookup("TeacherDAOBean/remote");
    }

	@Test
	public void testInsertTeacher() {
		Teacher teacher = new Teacher("何为");
		teacher.addStudent(new Student("叶子由"));
		teacher.addStudent(new Student("陈光照"));
		dao.insertTeacher(teacher);
	}

	@Test
	public void testGetAllTeacher() {
		List<Teacher> teachers = dao.getAllTeacher();
		for(Teacher teacher : teachers){
			System.out.println("================="+ teacher.toString() +"===================");
			for(Student student : teacher.getStudents()){
				System.out.println(student);
			}
		}
	}
	
	@Test
    public void cancelStudent(){
		dao.cancelStudent(1, 2);
    }
	
	@Test
    public void cancelAllStudent(){
		dao.cancelAllStudent(1);
    }
    
	@Test
	public void testDeleteTeacher() {
		dao.deleteTeacher(1);
	}
	
	@Test
	public void testDeleteStudent() {
		dao.deleteStudent(2);
	}
}
