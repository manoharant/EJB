package junit.test;

import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.OneToOneDAO;
import com.foshanshop.ejb3.bean.IDCard;
import com.foshanshop.ejb3.bean.Person;

public class OneToOneDAOTest {
    private static OneToOneDAO dao;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Properties props = new Properties();        
        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.provider.url", "localhost:1099");
        props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        InitialContext ctx = new InitialContext(props);
        dao = (OneToOneDAO) ctx.lookup("OneToOneDAOBean/remote");
    }

    @Test
    public void testInsertPerson() {
        Person person = new Person();
        person.setName("小张");
        person.setSex(true);
        person.setAge((short)26);
        person.setBirthday(new Date());
        IDCard idcard = new IDCard("60023032032032");
        idcard.setPerson(person);
        person.setIdcard(idcard);
        dao.insertPerson(person);
    }

    @Test
    public void testGetPersonByID() {
        Person person = dao.getPersonByID(1);
        System.out.println(person.getName());
        System.out.println("身份证:"+ person.getIdcard().getCardno());
    }

    @Test
    public void testUpdatePersonInfo() {
        dao.updatePersonInfo(1, "小明", "020210202102");
    }

    @Test
    public void testDeletePerson() {
        dao.deletePerson(9);
    }
}
