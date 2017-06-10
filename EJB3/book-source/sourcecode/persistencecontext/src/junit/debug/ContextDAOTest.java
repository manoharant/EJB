package junit.debug;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.ContextDAO;

public class ContextDAOTest {
	private static ContextDAO extendeddao;
	private static ContextDAO transactionScopeddao;
	private static ContextDAO extendedStatefuldao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		extendeddao = (ContextDAO)EJBFactory.getEJB("ExtendedBean/remote");
		transactionScopeddao = (ContextDAO)EJBFactory.getEJB("TransactionScopedBean/remote");
		extendedStatefuldao = (ContextDAO)EJBFactory.getEJB("ExtendedStatefulBean/remote");
	}

	@Test
	public void testtransactionScopedContains() {
		transactionScopeddao.initdata("С��");		
		assertFalse(transactionScopeddao.contains());

	}

	@Test
	public void testtransactionScopedUpdateName() {
		transactionScopeddao.initdata("С��");		
		transactionScopeddao.updateName("����Χ");
	}
	
	@Test
	public void testextendedContains() {
		extendeddao.initdata("С��");	
		assertTrue(extendeddao.contains());
		
	}
	
	@Test
	public void testextendedUpdateName() {
		extendeddao.initdata("С��");	
		extendeddao.updateName("����Χ");	
	}
	
	@Test
	public void testStatefulContains() {
		extendedStatefuldao.initdata("����");	
		assertTrue(extendedStatefuldao.contains());		
	}
	
	@Test
	public void testStatefulUpdateName() {
		extendedStatefuldao.initdata("����");	
		extendedStatefuldao.updateName("����Χ");
	}
	
}
