package junit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.BmtDAO;
import com.foshanshop.ejb3.bean.WebSite;

public class BmtDAOTest {
	private static BmtDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 try {
			Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.setProperty(Context.PROVIDER_URL, "localhost:1099");
			props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			InitialContext ctx = new InitialContext(props);
			dao = (BmtDAO) ctx.lookup("BmtDAOBean/remote");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJndisaveSite() {
		dao.jndisaveSite(new WebSite("web1", "http://www.foshanshop.com"));
	}
	
	@Test
	public void testContextsaveSite() {
		dao.contextsaveSite(new WebSite("web2", "http://www.babasport.com"));
	}
	
	@Test
	public void testCommit() {
		dao.commit(new WebSite("web3", "http://www.sina.com.cn"),
				new WebSite("sohu", "http://www.sohu.com"));
	}
	
	@Test
	public void testRollback() {
		dao.rollback(new WebSite("web4", "http://www.sina.com.cn"),
				new WebSite("sohu", "http://www.sohu.com"));
	}
}
