package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.LockingDAO;
import com.foshanshop.ejb3.bean.User;

@Stateless
@Remote(LockingDAO.class)
public class LockingDAOBean implements LockingDAO {
	@PersistenceContext protected EntityManager em;
	
	public void init(User user) {
		em.persist(user);
	}

	public void payElectricityFee(int id) {
		try {
			User user = em.find(User.class, id);
			Thread.sleep(3000);
			user.setBalance(user.getBalance()-200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void saveLaborage(int id) {
		try {
			User user = em.find(User.class, id);
			Thread.sleep(3500);
			user.setBalance(user.getBalance()+13000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
