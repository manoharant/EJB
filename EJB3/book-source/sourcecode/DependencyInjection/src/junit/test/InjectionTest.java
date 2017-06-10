package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.Injection;

public class InjectionTest {
	private static Injection injection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		injection = (Injection) EJBFactory.getEJB("InjectionBean/remote");
	}

	@Test
	public void testSayHello() {
		System.out.println(injection.SayHello());		
	}
}
