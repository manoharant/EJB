package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.foshanshop.ejb3.ContextDAO;
import com.foshanshop.ejb3.bean.Context;

@Stateful
@Remote(ContextDAO.class)
public class ExtendedStatefulBean implements ContextDAO {

	@PersistenceContext(unitName="foshanshop", type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	private Context context;
	
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

	public void updateName(String name) {
		context.setName(name);
	}
	
	public Context getContext() {
		return em.find(Context.class, context.getId());
	}
}
