package junit.test;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.PersonDAO;
import com.foshanshop.ejb3.bean.Person;
/**
 * 执行该用例，你需要JDK1.6以上版本，并且需要把[weblogic home]\wlserver_10.3\server\lib\weblogic.jar加入到项目的类路径下
 * @author lihuoming
 *
 */
public class PersonDAOTest {
	private static PersonDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			 Properties props = new Properties();
			 props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			 props.setProperty(Context.PROVIDER_URL, "t3://localhost:7001");
			 InitialContext ctx = new InitialContext(props);
			 dao = (PersonDAO) ctx.lookup("PersonDAOBean#"+ PersonDAO.class.getName());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInsertPerson() {
		Person person = new Person();
		person.setName("张朗");
		person.setAge((short)27);
		person.setBirthday(new Date());
		person.setSex(true);
		dao.insertPerson(person);
	}

	@Test
	public void testGetPersonList() {
		List<Person> persons = dao.getPersonList();
		for(Person person : persons){
			System.out.println("姓名="+person.getName()+",性别="+ person.getSex()+
					",年龄="+ person.getAge()+",生日="+ person.getBirthday());
		}
	}
}
