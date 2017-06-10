package junit.test;

import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.HelloChinaRemote;

public class HelloChinaRemoteTest {
	private static HelloChinaRemote dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        Properties props = new Properties();        
        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.provider.url", "localhost:1099");
        props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");

        InitialContext ctx = new InitialContext(props);
        dao = (HelloChinaRemote)ctx.lookup("HelloChinaBean/remote");
	}

	@Test
	public void testSayHello() {
		String out = dao.SayHello("Manoharan");
		System.out.println("Value==="+out);
	}

	@Test
	public void testMyname() {
		String out=dao.Myname();
		System.out.println("Value====="+out);
	}

}