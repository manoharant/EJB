package net.learntechnology.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.learntechnology.persistence.dao.UserDAO;
import net.learntechnology.persistence.entity.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
public class UserServiceBean implements UserService {
    private static Log log = LogFactory.getLog(UserServiceBean.class);
    
    UserDAO userDAO;

    @EJB
    public void setUserDAO(UserDAO userDAO) { 
        this.userDAO = userDAO;
    }
    
    public List<User> getUsers() {
        log.debug("getUsers");
        return userDAO.getUsers();
    }
}
