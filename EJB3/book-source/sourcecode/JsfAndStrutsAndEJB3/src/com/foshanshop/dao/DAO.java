package com.foshanshop.dao;

import java.util.LinkedHashMap;

import com.foshanshop.bean.QueryResult;

public interface DAO {
	/**
	 * ���Ҽ�¼
	 * @param <T>
	 * @param entityClass ʵ����
	 * @param primaryKey ����
	 * @return
	 */
	 public <T> T find(Class <T> entityClass, Object primaryKey);
	 /**
	  * �����¼
	  * @param entity ʵ��
	  */
	 public void save(Object entity);
	 /**
	  * ���¼�¼
	  * @param entity ʵ��
	  */
	 public void update(Object entity);
	 /**
	  * ɾ����¼
	 * @param entityClass ʵ����
	 * @param primaryKey ����
	  */
	 public void delete(Class<?> entityClass, Object primaryKey);
	 /**
	  * ��¼����ҳ
	  * @param entityClass ʵ����
      * @param firstResult ��ʼ����
      * @param maxResult ��ȡ���ٸ���¼
      * @param orderBy ���������������Ҫ�����������null.Ԫ�ص�KeyΪʵ���ֶ�����valueΪASC/DESC���磺
      * LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
      * orderBy.put("newsid", "DESC");
	  */
	 public QueryResult getResultList(Class<?> entityClass, int firstResult, int maxResult, LinkedHashMap<String, String> orderBy);
}
