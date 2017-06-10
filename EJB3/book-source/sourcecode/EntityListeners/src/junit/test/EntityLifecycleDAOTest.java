package junit.test;

import junit.test.EJBFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.EntityLifecycleDAO;

public class EntityLifecycleDAOTest {
	private static EntityLifecycleDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 dao = (EntityLifecycleDAO)EJBFactory.getEJB("EntityLifecycleDAOBean/remote");
	}

	@Test
	public void testPersist() {
		dao.Persist();
	}

	@Test
	public void testLoad() {
		dao.Load();
	}

	@Test
	public void testUpdate() {
		dao.Update();
	}

	@Test
	public void testRemove() {
		dao.Remove();
	}

}
