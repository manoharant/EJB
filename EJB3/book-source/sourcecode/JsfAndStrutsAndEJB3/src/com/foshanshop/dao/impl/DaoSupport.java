package com.foshanshop.dao.impl;

import java.util.LinkedHashMap;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.bean.QueryResult;
import com.foshanshop.dao.DAO;
/**
 * DAOͨ�ò�����
 * @author lihuoming
 *
 */
public abstract class DaoSupport implements DAO {
    @PersistenceContext protected EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public <T> T find(Class <T> entityClass, Object primaryKey){
       T obj = em.find(entityClass, primaryKey);
       return obj;
    }

    public void save(Object entity){
        em.persist(entity);
    }

    public void update(Object entity){
         em.merge(entity);
    }
    
	@SuppressWarnings("unchecked")
	public void delete(Class entityClass, Object primaryKey){
    	em.remove(em.getReference(entityClass, primaryKey));
    }
	
	public QueryResult getResultList(Class<?> entityClass, int firstResult, int maxResult, LinkedHashMap<String, String> orderBy){
		String entityname = entityClass.getSimpleName();//�����û���޸Ĺ�@Entity.name()��ʵ�����Ƽ�Ϊ���޶�����
        QueryResult qr = new QueryResult(); 
        Query query = em.createQuery("select o from "+ entityname+ " o"+ buildOrderby(orderBy));
        //���firstResult=-1��maxResult=-1������ȡȫ����¼������ҳ
        if (firstResult!= -1 && maxResult!= -1) query.setMaxResults(maxResult).setFirstResult(firstResult);
        qr.setResultset(query.getResultList());
        query = em.createQuery("select count(o) from "+ entityname+ " o");
        qr.setRecordtotal((Long)query.getSingleResult());
        return qr;
    }
	
    /**
     * ������������Ӿ�
     * @param orderby ������-ASC/DESC��ʽ��LinkedHashMap����
     */ 
    private static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer out = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			out.append(" order by ");
			for(String key : orderby.keySet()){
				out.append("o."+ key+ " "+ orderby.get(key));
				out.append(",");
			}
			out.deleteCharAt(out.length()-1);
		}
		return out.toString();
    }
}
