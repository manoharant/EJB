package com.foshanshop.ejb3.impl;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.OtherDAO;
import com.foshanshop.ejb3.AppException;
import com.foshanshop.ejb3.TransactionDAO;
import com.foshanshop.ejb3.bean.Product;

@Stateless
@Remote (TransactionDAO.class)
public class TransactionDAOBean implements TransactionDAO {
    @PersistenceContext protected EntityManager em;
    @EJB OtherDAO otherejb;
    @Resource SessionContext ejbcontext;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void systemException() {
    	otherejb.systemException();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void AppException() throws AppException{
    	em.persist(new Product("Product1", (float)27));
        throw new AppException ("Product1 Exception");
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void setRollback(){
    	em.persist(new Product("Product2", (float)86));
    	ejbcontext.setRollbackOnly();
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void requried_notInTransaction(){
    	otherejb.required();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void requried_inTransaction(){
    	otherejb.required();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Product notSupported_runInTransaction(Product product){
    	em.persist(product);
    	em.flush();
    	Product result = otherejb.notSupported(product.getProductid());
    	product.setName("Prodcut updated");
    	return result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void mandatory_inTransaction(){
    	otherejb.mandatory();
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void mandatory_notInTransaction(){
    	otherejb.mandatory();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void requirednew_inTransaction(){
    	Product p = new Product("Product3", (float)56);
    	em.persist(p);
    	otherejb.requirednew();
    	p.setName("Product2 updated");
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void requirednew_notInTransaction(){
    	otherejb.requirednew();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Product support_inTransaction(){
    	Product p = new Product("Product 4", (float)920);
    	em.persist(p);
    	em.flush();
    	Product result = otherejb.support(p.getProductid());
    	p.setName("Prodcut3 updated");
    	return result;
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Product support_notInTransaction(){
    	return otherejb.support(1);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Product never_inTransaction(int productid){
    	return otherejb.never(productid);
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Product never_notInTransaction(int productid){
    	return otherejb.never(productid);
    }
}
