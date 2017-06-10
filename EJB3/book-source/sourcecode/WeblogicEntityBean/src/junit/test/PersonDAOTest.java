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
 * ִ�и�����������ҪJDK1.6���ϰ汾��������Ҫ��[weblogic home]\wlserver_10.3\server\lib\weblogic.jar���뵽��Ŀ����·����
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
		person.setName("����");
		person.setAge((short)27);
		person.setBirthday(new Date());
		person.setSex(true);
		dao.insertPerson(person);
	}

	@Test
	public void testGetPersonList() {
		List<Person> persons = dao.getPersonList();
		for(Person person : persons){
			System.out.println("����="+person.getName()+",�Ա�="+ person.getSex()+
					",����="+ person.getAge()+",����="+ person.getBirthday());
		}
	}
}
