package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.CodeSolveDAO;
import com.foshanshop.ejb3.bean.User;

@Stateless
@Remote(CodeSolveDAO.class)
public class CodeSolveDAOBean implements CodeSolveDAO {
	@PersistenceContext protected EntityManager em;
	
	public void init(User user) {
		em.persist(user);
	}

	public void payElectricityFee(int id) {
		Query query = em.createQuery("update User set balance=balance-200 where id=?1");
		query.setParameter(1, id);
		query.executeUpdate();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void saveLaborage(int id) {
		Query query = em.createQuery("update User set balance=balance+13000 where id=?1");
		query.setParameter(1, id);
		query.executeUpdate();
	}
}
