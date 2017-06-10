package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.EntityLifecycleDAO;
import com.foshanshop.ejb3.bean.EntityLifecycle;

@Stateless
@Remote (EntityLifecycleDAO.class)
@SuppressWarnings("unchecked")
public class EntityLifecycleDAOBean implements EntityLifecycleDAO {
    @PersistenceContext protected EntityManager em;
    
    public EntityLifecycle Load() {
        return em.find(EntityLifecycle.class, 1);
    }

    public void Persist() {
        EntityLifecycle entitylifecycle = new EntityLifecycle("Persist");
        em.persist(entitylifecycle);
    }

	public void Remove() {
        Query query = em.createQuery("select e from EntityLifecycle e");
        List<EntityLifecycle> result = (List<EntityLifecycle>)query.getResultList();
        if (result.size()>0){
            EntityLifecycle entitylifecycle = result.get(0);
            em.remove(entitylifecycle);
        }
    }

    public void Update() {
        Query query = em.createQuery("select e from EntityLifecycle e");
        List<EntityLifecycle> result = (List<EntityLifecycle>)query.getResultList();
        if (result.size()>0){
            EntityLifecycle entitylifecycle = result.get(0);
            entitylifecycle.setName("Update"); 
        }       
    }
}
