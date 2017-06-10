package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Context;

public interface ContextDAO {
    /**
     * 是否托管状态
     * @return
     */
	public boolean contains();
	/**
	 * 初始化数据
	 */
	public void initdata(String name);
	/**
	 * 更新名称
	 * @param name 名称
	 */
	public void updateName(String name);
	/**
	 * 获取实体bean
	 */
	public Context getContext();
}
