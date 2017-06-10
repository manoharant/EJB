package com.foshanshop.ejb3.impl;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.foshanshop.ejb3.BmtDAO;
import com.foshanshop.ejb3.bean.WebSite;

@Stateless
@Remote (BmtDAO.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class BmtDAOBean implements BmtDAO {
    @PersistenceContext protected EntityManager em;
    @Resource SessionContext ejbcontext;
    @Resource UserTransaction ut;

    public void commit(WebSite webSite1, WebSite webSite2){
    	try {
			ut.begin();
			em.persist(webSite1);
			em.persist(webSite2);
			ut.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ut.rollback();
			} catch (Exception e1) {}
		}
    }

    public void rollback(WebSite webSite1, WebSite webSite2){
    	try {
			ut.begin();
			em.persist(webSite1);
			String babasport = null;
			babasport.toUpperCase();
			em.persist(webSite2);
			ut.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {ut.rollback();} catch (Exception e1) {}
		}
    }

    public void jndisaveSite(WebSite webSite){
    	try {
    		InitialContext context = new InitialContext();
    		UserTransaction uts = (UserTransaction)context.lookup("java:comp/UserTransaction");
    		uts.begin();
			em.persist(webSite);
			uts.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void contextsaveSite(WebSite webSite){
    	try {
    		UserTransaction uts = ejbcontext.getUserTransaction();
    		uts.begin();
			em.persist(webSite);
			uts.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
