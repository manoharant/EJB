package blogspot.sezera.exampleproject.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDaoImpl<T extends Serializable,ID extends Serializable> implements
GenericDao<T,ID>{
	
	private SessionFactory sessionFactory;

	public GenericDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
