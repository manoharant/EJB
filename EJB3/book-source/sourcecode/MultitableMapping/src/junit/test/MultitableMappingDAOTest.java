package junit.test;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.MultitableMappingDAO;
import com.foshanshop.ejb3.bean.MainTable;

public class MultitableMappingDAOTest {
    private static MultitableMappingDAO dao;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.setProperty(Context.PROVIDER_URL, "localhost:1099");
        InitialContext ctx = new InitialContext(props);
        dao = (MultitableMappingDAO) ctx.lookup("MultitableMappingDAOBean/remote");
    }

	@Test
	public void testSave() {
		MainTable mainTable = new MainTable();
		mainTable.setName("张郞");
		mainTable.setAddress("北京和平里一号");
		mainTable.setPostcode("100081");
		dao.save(mainTable);
	}

	@Test
	public void testGetMainTables() {
		List<MainTable> mainTables = dao.getMainTables();
		for(MainTable mainTable : mainTables){
			System.out.println(mainTable);
		}
	}

}
