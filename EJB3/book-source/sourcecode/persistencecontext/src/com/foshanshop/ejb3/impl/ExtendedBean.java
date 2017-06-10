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
			em.persist(context);//��ʱ��context��Ϊ�йܶ���
		}
	}
	
	public boolean contains() {
		return em.contains(context);
	}

	public void updateName(String name) {
		context.setName(name);
		//��extended persistence contextע���JTA������
		em.joinTransaction();
	}
	public Context getContext() {
		return em.find(Context.class, context.getId());
	}
}
