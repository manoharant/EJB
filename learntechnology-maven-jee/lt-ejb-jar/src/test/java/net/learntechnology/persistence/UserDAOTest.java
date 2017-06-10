package net.learntechnology.persistence;

import java.util.List;

import net.learntechnology.persistence.dao.*;
import net.learntechnology.persistence.entity.User;
import net.learntechnology.persistence.entity.Customers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups={"unit"}) 
public class UserDAOTest extends BaseTest {

    private static Log log = LogFactory.getLog(UserDAOTest.class);
    private UserDAO userDao = new UserDAOBean();
    private CustomerDAO customerDao = new CustomerDAOBean();
    
    public void getUsers() throws Exception {  
        log.debug("getting users");
        List<User> users = userDao.getUsers(); 
        Assert.assertTrue(users.size() > 0);
    }
    
    public void findByCusID() throws Exception {  
        log.debug("getting users");
        Customers customer = customerDao.findByCusID("112");
        Assert.assertTrue(customer.getAddressLine1().length()>0);
    }
    
    public void getCustomers() throws Exception {  
        log.debug("getting customers");
        List<Customers> customers = customerDao.getCustomers(); 
        Assert.assertTrue(customers.size() > 0);
    }
     
    @BeforeClass    
    public  void runBeforeClass()  {
        log.info("runBeforeClass");
        setUp(BaseTest.EM_TEST_HSQLDB);
        customerDao.setEm(em);
        userDao.setEm( em );
    }
    
    @AfterClass 
    public  void runAfterClass()  {
        log.info("runAfterClass");
        tearDown();
    }
  
}