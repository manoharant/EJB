package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.MultitableMappingDAO;
import com.foshanshop.ejb3.bean.MainTable;

@Stateless
@Remote (MultitableMappingDAO.class)
public class MultitableMappingDAOBean implements MultitableMappingDAO {
	@PersistenceContext protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<MainTable> getMainTables() {
        Query query = em.createQuery("select o from MainTable o order by o.id asc");
        return (List<MainTable>) query.getResultList();
	}

	public void save(MainTable mainTable) {
		em.persist(mainTable);		
	}
}
