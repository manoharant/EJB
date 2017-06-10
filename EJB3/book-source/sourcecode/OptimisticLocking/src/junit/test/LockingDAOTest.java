package junit.test;

import java.util.Properties;
import java.util.Timer;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.LockingDAO;
import com.foshanshop.ejb3.bean.User;

public class LockingDAOTest {
	private static LockingDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			 Properties props = new Properties();
			 props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			 props.setProperty(Context.PROVIDER_URL, "localhost:1099");
			 props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			 InitialContext ctx = new InitialContext(props);
			 dao = (LockingDAO) ctx.lookup("LockingDAOBean/remote");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSolveUpdateLose() {
		dao.init(new User(10000));
		Timer timer = new Timer();
		timer.schedule(new ATask(), 1);
		
		Timer timer2 = new Timer();
		timer2.schedule(new BTask(), 1000);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {}
		timer.cancel();
		timer2.cancel();
	}
	
	static class ATask extends java.util.TimerTask{
		@Override
		public void run() {
			System.out.println("========ATask started=========");
			dao.payElectricityFee(1);
			System.out.println("========ATask ended=========");
		}
	}
	
	static class BTask extends java.util.TimerTask{
		@Override
		public void run() {
			System.out.println("========BTask started=========");
			try {
				//javax.persistence.OptimisticLockException
				dao.saveLaborage(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("========BTask ended=========");
		}
	}
}
