package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.ContextDAO;
import com.foshanshop.ejb3.bean.Context;

@Stateless
@Remote (ContextDAO.class)
public class TransactionScopedBean implements ContextDAO {
	@PersistenceContext(unitName="foshanshop") private EntityManager em;
	private static Context context;
	
	public void initdata(String name){
		if(context==null){
			context = new Context();
			context.setName(name);
			em.persist(context);//此时的context成为托管对象			
		}
	}
	
	public boolean contains() {
		return em.contains(context);
	}
	
	public void updateName(String name){
		context.setName(name);
	}

	public Context getContext() {
		return em.find(Context.class, context.getId());
	}
}
