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
		transactionScopeddao.initdata("小张");		
		assertFalse(transactionScopeddao.contains());

	}

	@Test
	public void testtransactionScopedUpdateName() {
		transactionScopeddao.initdata("小张");		
		transactionScopeddao.updateName("事务范围");
	}
	
	@Test
	public void testextendedContains() {
		extendeddao.initdata("小美");	
		assertTrue(extendeddao.contains());
		
	}
	
	@Test
	public void testextendedUpdateName() {
		extendeddao.initdata("小美");	
		extendeddao.updateName("事务范围");	
	}
	
	@Test
	public void testStatefulContains() {
		extendedStatefuldao.initdata("李明");	
		assertTrue(extendedStatefuldao.contains());		
	}
	
	@Test
	public void testStatefulUpdateName() {
		extendedStatefuldao.initdata("李明");	
		extendedStatefuldao.updateName("事务范围");
	}
	
}
