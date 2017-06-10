package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.UpdateLoseDAO;
import com.foshanshop.ejb3.bean.User;
@Stateless
@Remote(UpdateLoseDAO.class)
public class UpdateLoseDAOBean implements UpdateLoseDAO {
	@PersistenceContext protected EntityManager em;
	
	public void init(User user) {
		em.persist(user);
	}
	
	public String payElectricityFee(int id) {
		try {
			User user = em.find(User.class, id);
			String out = "payElectricityFee"+ user.getBalance();
			Thread.sleep(3000);
			user.setBalance(user.getBalance()-200);
			return out;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String saveLaborage(int id) {
		try {
			User user = em.find(User.class, id);
			String out = "saveLaborage"+ user.getBalance();
			Thread.sleep(4000);
			user.setBalance(user.getBalance()+13000);
			return out;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String secondPayElectricityFee(int id) {
		try {
			User user = em.find(User.class, id);
			String out = "secondPayElectricityFee"+ user.getBalance();
			user.setBalance(user.getBalance()-200);
			em.flush();
			Thread.sleep(2000);
			return out;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String secondSaveLaborage(int id) {
		try {			
			User user = em.find(User.class, id);
			String out = "secondSaveLaborage"+ user.getBalance();
			Thread.sleep(4000);
			user.setBalance(user.getBalance()+13000);
			return out;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
