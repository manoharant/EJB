package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Person;

public interface PersonDAO {
	/**
	 * ���һ��Person
	 * @param person ��Ա
	 */
    public void insertPerson(Person person);
    /**
     * ��ȡȫ��Person
     * @return
     */
    public List<Person> getPersonList();
}
