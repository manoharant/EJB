package com.foshanshop.ejb3.impl;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.PersonDAO;
import com.foshanshop.ejb3.bean.Person;

@Stateless
@Remote (PersonDAO.class)
public class PersonDAOBean implements PersonDAO {
    @PersistenceContext(unitName="foshanshop") protected EntityManager em;

    public void insertPerson(Person person) {
        em.persist(person);
    }

    public Person getPersonByID(int personid) {       
        return em.find(Person.class, personid);
    }
    
    public void mergePerson(Person person) {
       em.merge(person);
    }
    
    @SuppressWarnings("unchecked")
	public List<Person> getPersonList() {
        Query query = em.createQuery("select o from Person o order by o.personid asc");
        return (List<Person>) query.getResultList();
    }

	public void deletePerson(int personid) {
		Person person = em.find(Person.class, personid);
		if(person!=null) em.remove(person);
	}

	public void updateName(String newname, int personid) {
		Person person = em.find(Person.class, personid);
		if(person!=null) person.setName(newname);
	} 
}
