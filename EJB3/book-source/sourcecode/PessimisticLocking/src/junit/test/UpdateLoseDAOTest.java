package junit.test;

import java.util.Properties;
import java.util.Timer;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.UpdateLoseDAO;
import com.foshanshop.ejb3.bean.User;

public class UpdateLoseDAOTest {
	private static UpdateLoseDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 try {
			Properties props = new Properties();
			 props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			 props.setProperty(Context.PROVIDER_URL, "localhost:1099");
			 props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			 InitialContext ctx = new InitialContext(props);
			 dao = (UpdateLoseDAO) ctx.lookup("UpdateLoseDAOBean/remote");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateLose() {
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

	@Test
	public void testSecondUpdateLose() {
		dao.init(new User(10000));
		
		Timer timer = new Timer();
		
		timer.schedule(new CTask(), 1);
		
		Timer timer2 = new Timer();
		timer2.schedule(new DTask(), 1000);
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
			System.out.println(dao.payElectricityFee(1));
			System.out.println("========ATask ended=========");
		}
	}
	
	static class BTask extends java.util.TimerTask{
		@Override
		public void run() {
			System.out.println("========BTask started=========");
			try {
				System.out.println(dao.saveLaborage(1));
			} catch (RuntimeException e) {
				System.out.println("exception");
			}
			System.out.println("========BTask ended=========");
		}
	}
	
	static class CTask extends java.util.TimerTask{
		@Override
		public void run() {
			System.out.println("========CTask started=========");
			System.out.println(dao.secondPayElectricityFee(1));
			System.out.println("========CTask ended=========");
		}
	}
	
	static class DTask extends java.util.TimerTask{
		@Override
		public void run() {
			System.out.println("========DTask started=========");
			System.out.println(dao.secondSaveLaborage(1));
			System.out.println("========DTask ended=========");
		}
	}
}
