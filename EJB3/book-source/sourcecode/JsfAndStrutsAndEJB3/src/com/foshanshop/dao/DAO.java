package com.foshanshop.dao;

import java.util.LinkedHashMap;

import com.foshanshop.bean.QueryResult;

public interface DAO {
	/**
	 * 查找记录
	 * @param <T>
	 * @param entityClass 实体类
	 * @param primaryKey 主键
	 * @return
	 */
	 public <T> T find(Class <T> entityClass, Object primaryKey);
	 /**
	  * 保存记录
	  * @param entity 实体
	  */
	 public void save(Object entity);
	 /**
	  * 更新记录
	  * @param entity 实体
	  */
	 public void update(Object entity);
	 /**
	  * 删除记录
	 * @param entityClass 实体类
	 * @param primaryKey 主键
	  */
	 public void delete(Class<?> entityClass, Object primaryKey);
	 /**
	  * 记录集分页
	  * @param entityClass 实体类
      * @param firstResult 开始索引
      * @param maxResult 获取多少个记录
      * @param orderBy 用于排序，如果不需要排序可以填入null.元素的Key为实体字段名，value为ASC/DESC，如：
      * LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
      * orderBy.put("newsid", "DESC");
	  */
	 public QueryResult getResultList(Class<?> entityClass, int firstResult, int maxResult, LinkedHashMap<String, String> orderBy);
}
