package junit.test;

import java.util.Properties;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.AirLineDAO;
import com.foshanshop.ejb3.bean.AirLine;

public class AirLineDAOTest {

    private static  AirLineDAO dao;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.provider.url", "localhost:1099");
        props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        InitialContext ctx = new InitialContext(props);
        dao = (AirLineDAO) ctx.lookup("AirLineDAOBean/remote");
    }

    @Test
    public void testInsertAirLine() {
        dao.insertAirLine();
    }

    @Test
    public void testGetAirLineByID() {
        AirLine airLine = dao.getAirLineByID("PEK", "CAN");
        System.out.println(airLine.getId().toString());
    }

}
