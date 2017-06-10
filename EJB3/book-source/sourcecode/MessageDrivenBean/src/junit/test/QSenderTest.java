package junit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.QSender;

public class QSenderTest {
	private static QSender sender;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 Properties props = new Properties();

		         props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		         props.setProperty("java.naming.provider.url", "localhost:1099");
		         props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");

         InitialContext ctx = new InitialContext(props);
         sender = (QSender) ctx.lookup("QSenderBean/remote");
	}

	@Test
	public void testSend() {
		sender.send();
	}
}
