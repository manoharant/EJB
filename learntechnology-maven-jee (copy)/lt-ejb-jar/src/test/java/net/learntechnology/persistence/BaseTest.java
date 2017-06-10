package net.learntechnology.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseTest {
    private static Log log = LogFactory.getLog(BaseTest.class);
    protected EntityManagerFactory emf;
    public EntityManager em;
    
    public static final String EM_TEST_HSQLDB = "test-hsqldb";
    
    protected void setUp(String emName)   {
        log.info("retrieving EntityManager: "+emName );
        emf = Persistence.createEntityManagerFactory(emName);
        em = emf.createEntityManager(); 
    }
   
    protected void tearDown()  {
        log.info("closing EntityManagerFactory"); 
        emf.close();
    }
    
}
