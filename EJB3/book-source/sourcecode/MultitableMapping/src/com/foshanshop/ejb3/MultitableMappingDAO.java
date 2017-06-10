package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.MainTable;

public interface MultitableMappingDAO {
	/**
	 * 保存MainTable
	 * @param mainTable
	 */
	public void save(MainTable mainTable);
	/**
	 * 获取所有MainTable
	 * @return
	 */
	public List<MainTable> getMainTables();
}
