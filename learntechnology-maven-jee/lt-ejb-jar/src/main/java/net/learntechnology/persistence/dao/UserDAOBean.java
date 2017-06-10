package net.learntechnology.persistence.dao;
 
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.learntechnology.persistence.entity.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
@Stateless
public class UserDAOBean implements UserDAO {
    private static Log log = LogFactory.getLog(UserDAOBean.class);
     
    private EntityManager em; 
     
    @PersistenceContext(unitName="OurEntityManager")
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<User> getUsers() {
        log.debug("getUsers");
		List<User> users = this.em.createQuery("select user from User user order by user.lastName").getResultList();
		return users;
    }
 
	//not using this method in this example app
	public User saveUser(User user) {
        log.debug("saveUser: "+user);
        this.em.persist(user);
        this.em.flush();
        return user;
    }
}
