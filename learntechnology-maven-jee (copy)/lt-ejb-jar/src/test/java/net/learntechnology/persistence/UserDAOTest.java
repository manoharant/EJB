package net.learntechnology.persistence;

import java.util.List;

import net.learntechnology.persistence.dao.UserDAO;
import net.learntechnology.persistence.dao.UserDAOBean;
import net.learntechnology.persistence.entity.User;

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
    
    public void getUsers() throws Exception {  
        log.debug("getting users");
        List<User> users = userDao.getUsers(); 
        Assert.assertTrue(users.size() > 0);
    }
     
    @BeforeClass    
    public  void runBeforeClass()  {
        log.info("runBeforeClass");
        setUp(BaseTest.EM_TEST_HSQLDB);
        userDao.setEm( em );
    }
    
    @AfterClass 
    public  void runAfterClass()  {
        log.info("runAfterClass");
        tearDown();
    }
  
}