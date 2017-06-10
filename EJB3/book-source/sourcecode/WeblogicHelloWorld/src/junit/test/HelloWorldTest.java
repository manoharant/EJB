package junit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import com.foshanshop.ejb3.HelloWorld;
/**
 * 执行该用例，你需要JDK1.6以上版本，并且需要把[weblogic home]\wlserver_10.3\server\lib\weblogic.jar加入到类路径下
 * @author lihuoming
 *
 */
public class HelloWorldTest {
	
	@Test
	public void testSayHello() {
		try {
			 Properties props = new Properties();
			 props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			 props.setProperty(Context.PROVIDER_URL, "t3://localhost:7001");
			 InitialContext ctx = new InitialContext(props);
			 HelloWorld remote = (HelloWorld) ctx.lookup("HelloWorldBean#"+ HelloWorld.class.getName());
			 System.out.println(remote.SayHello("远古人"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
