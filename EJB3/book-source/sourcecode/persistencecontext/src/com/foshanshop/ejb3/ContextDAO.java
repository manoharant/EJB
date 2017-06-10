package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Context;

public interface ContextDAO {
    /**
     * �Ƿ��й�״̬
     * @return
     */
	public boolean contains();
	/**
	 * ��ʼ������
	 */
	public void initdata(String name);
	/**
	 * ��������
	 * @param name ����
	 */
	public void updateName(String name);
	/**
	 * ��ȡʵ��bean
	 */
	public Context getContext();
}
