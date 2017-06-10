package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.PessimisticLockDAO;
import com.foshanshop.ejb3.bean.User;

@Stateless
@Remote(PessimisticLockDAO.class)
public class PessimisticLockDAOBean implements PessimisticLockDAO {
	@PersistenceContext protected EntityManager em;
	
	public void init(User user) {
		em.persist(user);
	}
	
	public void payElectricityFee(int id) {
		try {
			Query query = em.createNativeQuery("select * from users where id=? FOR UPDATE", User.class);			
			User user = (User)query.setParameter(1, id).getResultList().get(0);
			Thread.sleep(5000);
			user.setBalance(user.getBalance()-200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void saveLaborage(int id) {
		Query query = em.createNativeQuery("select * from users where id=? FOR UPDATE", User.class);
		User user = (User)query.setParameter(1, id).getResultList().get(0);
		user.setBalance(user.getBalance()+13000);
	}
	
}
