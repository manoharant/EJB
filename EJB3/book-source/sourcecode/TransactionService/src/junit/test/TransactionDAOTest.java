package junit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.AppException;
import com.foshanshop.ejb3.TransactionDAO;
import com.foshanshop.ejb3.bean.Product;

public class TransactionDAOTest {
	private static TransactionDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 try {
			Properties props = new Properties();
			 props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			 props.setProperty(Context.PROVIDER_URL, "localhost:1099");
			 props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			 InitialContext ctx = new InitialContext(props);
			 dao = (TransactionDAO) ctx.lookup("TransactionDAOBean/remote");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
   @Test
	public void systemException() {
		dao.systemException();
	}
   @Test
	public void AppException() {
		try {
			dao.AppException();
		} catch (AppException e) {
			e.printStackTrace();
		}
	}
   @Test
	public void setRollback(){
		dao.setRollback();
	}
   @Test
    public void requried_notInTransaction(){
		dao.requried_notInTransaction();
	}
   @Test
    public void requried_inTransaction(){
		dao.requried_inTransaction();
	}
    @Test
    public void notSupported_runInTransaction(){
    	System.out.println("Testing the TransactionDAO");
    	System.out.println(
    			dao.notSupported_runInTransaction(
    					new Product("notSupported_runInTransaction", (float)373)));
	}
    @Test
    public void mandatory_inTransaction(){
		dao.mandatory_inTransaction();
	}
    @Test
    public void mandatory_notInTransaction(){
		dao.mandatory_notInTransaction();
	}
    @Test
    public void requirednew_inTransaction(){
		dao.requirednew_inTransaction();
	}
    @Test
    public void requirednew_notInTransaction(){
		dao.requirednew_notInTransaction();
	}
    @Test
    public void support_inTransaction(){
    	System.out.println(dao.support_inTransaction());
	}
    @Test
    public void support_notInTransaction(){
    	System.out.println(dao.support_notInTransaction());
	}
    @Test
    public void never_inTransaction(){
    	System.out.println(dao.never_inTransaction(1));
	}
    @Test
    public void never_notInTransaction(){
		System.out.println(dao.never_notInTransaction(1));
	}
}
