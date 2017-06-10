package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Person;

public interface PersonDAO {
	public void insertPerson(Person person);
    public void updateName(String newname, int personid);
    public void mergePerson(Person person);
    public void deletePerson(int personid);
    public Person getPersonByID(int personid);
    public List<Person> getPersonList();
}
