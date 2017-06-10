package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.foshanshop.ejb3.ContextDAO;
import com.foshanshop.ejb3.bean.Context;

@Stateless
@Remote (ContextDAO.class)
public class ExtendedBean implements ContextDAO {
	@PersistenceUnit(unitName="foshanshop") EntityManagerFactory factory;
	private static Context context;
	private static EntityManager em;
	
	public void initdata(String name){
		if(em==null) em = factory.createEntityManager();
		if(context==null){
			context = new Context();
			context.setName(name);
			em.persist(context);//此时的context成为托管对象
		}
	}
	
	public boolean contains() {
		return em.contains(context);
	}

	public void updateName(String name) {
		context.setName(name);
		//把extended persistence context注册进JTA事务当中
		em.joinTransaction();
	}
	public Context getContext() {
		return em.find(Context.class, context.getId());
	}
}
