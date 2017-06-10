package com.foshanshop.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.OtherDAO;
import com.foshanshop.ejb3.RemoteOtherDAO;
import com.foshanshop.ejb3.bean.Product;

@Stateless
@Local(OtherDAO.class)
@Remote(RemoteOtherDAO.class)
public class OtherDAOBean implements OtherDAO{
    @PersistenceContext protected EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void systemException() {
    	Product product = new Product("systemException", (float)45);
        em.persist(product);
        String babasport = null;
        babasport.toUpperCase();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void required(){
    	 em.persist(new Product("required", (float)790));
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Product notSupported(int productid) {
    	return em.find(Product.class, productid);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void requirednew() {
        em.persist(new Product("requirednew", (float)82));
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Product support(int productid) {
    	return em.find(Product.class, productid);
    }
    
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void mandatory() {
        em.persist(new Product("mandatory", (float)52));
    }
    
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public Product never(int productid) {
    	return em.find(Product.class, productid);
    }
}