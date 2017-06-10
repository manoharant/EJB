package junit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import com.foshanshop.ejb3.HelloWorld;
/**
 * ִ�и�����������ҪJDK1.6���ϰ汾��������Ҫ��[weblogic home]\wlserver_10.3\server\lib\weblogic.jar���뵽��·����
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
			 System.out.println(remote.SayHello("Զ����"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
