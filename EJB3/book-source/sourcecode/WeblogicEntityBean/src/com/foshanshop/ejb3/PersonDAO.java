package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Person;

public interface PersonDAO {
	/**
	 * 添加一个Person
	 * @param person 人员
	 */
    public void insertPerson(Person person);
    /**
     * 获取全部Person
     * @return
     */
    public List<Person> getPersonList();
}
