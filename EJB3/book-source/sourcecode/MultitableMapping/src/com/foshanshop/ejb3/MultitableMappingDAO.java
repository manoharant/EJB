package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.MainTable;

public interface MultitableMappingDAO {
	/**
	 * ����MainTable
	 * @param mainTable
	 */
	public void save(MainTable mainTable);
	/**
	 * ��ȡ����MainTable
	 * @return
	 */
	public List<MainTable> getMainTables();
}
