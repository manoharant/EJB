package junit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.SecurityAccess;

public class SecurityAccessTest {
	private static SecurityAccess securityaccess;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL, "localhost:1099");
		props.setProperty(Context.SECURITY_PRINCIPAL, "lihuoming");
		props.setProperty(Context.SECURITY_CREDENTIALS, "123456");
		InitialContext ctx = new InitialContext(props);
		securityaccess = (SecurityAccess) ctx.lookup("SecurityAccessBean/remote");
	}

	@Test
	public void testAdminUserMethod() {
		System.out.println(securityaccess.AdminUserMethod());
	}

	@Test
	public void testDepartmentUserMethod() {
		System.out.println(securityaccess.DepartmentUserMethod());
	}

	@Test
	public void testAnonymousUserMethod() {
		System.out.println(securityaccess.AnonymousUserMethod());
	}

}
