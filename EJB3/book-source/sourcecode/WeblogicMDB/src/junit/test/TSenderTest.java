package junit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.TSender;

public class TSenderTest {
	private static TSender sender;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 try {
			Properties props = new Properties();
			 props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			 props.setProperty(Context.PROVIDER_URL, "t3://localhost:7001");
			 InitialContext ctx = new InitialContext(props);
			 sender = (TSender) ctx.lookup("TSenderBean#"+ TSender.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSend() {
		sender.send("°Í°ÍÔË¶¯Íø-http://www.babasport.com");
	}
}
