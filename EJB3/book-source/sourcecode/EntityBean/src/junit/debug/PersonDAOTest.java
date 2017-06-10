package junit.debug;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.PersonDAO;
import com.foshanshop.ejb3.bean.Person;

public class PersonDAOTest {
    private static PersonDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	    dao = (PersonDAO)EJBFactory.getEJB("PersonDAOBean/remote");
	}

	@Test
	public void testInsertPerson() {
		Person person = new Person();
		person.setName("Manoharan");
		person.setAge((short)27);
		person.setBirthday(new Date());
		person.setSex(true);
		dao.insertPerson(person);
	}

	@Test
	public void testUpdateName() {
		dao.updateName("Thambi", 2);
	}

	@Test
	public void testMergePerson() {
		Person person = dao.getPersonByID(2);
		assertNotNull(person);
		if(person!=null){
			person.setAge((short)25);
			person.setSex(false);
			dao.mergePerson(person);
		}
	}

	@Test
	public void testMergePersonforNewObject() {
		Person person = new Person();
		person.setName("Manoharan");
		person.setAge((short)23);
		person.setBirthday(new Date());
		person.setSex(false);
		dao.mergePerson(person);
	}

	@Test
	public void testDeletePerson() {
		dao.deletePerson(1);
	}

	@Test
	public void testGetPersonByID() {
		Person person = dao.getPersonByID(2);
		assertNotNull(person);
		if(person!=null){
			System.out.println("Name"+person.getName()+",Sex="+ person.getSex()+
				",AGE="+ person.getAge()+",DOB="+ person.getBirthday());
		}
	}

	@Test
	public void testGetPersonList() {
		List<Person> persons = dao.getPersonList();
		for(Person person : persons){
			System.out.println("Name="+person.getName()+",Sex="+ person.getSex()+
					",AGE="+ person.getAge()+",DOB="+ person.getBirthday());
		}
	}
}
