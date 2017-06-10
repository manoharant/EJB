package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.foshanshop.ejb3.OneToOneDAO;
import com.foshanshop.ejb3.bean.Person;

@Stateless
@Remote (OneToOneDAO.class)
public class OneToOneDAOBean implements OneToOneDAO {
    @PersistenceContext protected EntityManager em;

    public void insertPerson(Person person) {
        em.persist(person); 
    }
    
    public Person getPersonByID(Integer personid) {
        Person person = em.find(Person.class, personid);
        return person;
    }

    public void updatePersonInfo(Integer personid, String newname, String newIDcard) {
        Person person = em.find(Person.class, personid);
        if (person!=null) {
            person.setName(newname);
            if (person.getIdcard()!=null){
                person.getIdcard().setCardno(newIDcard);
            } 
        }
    }    

    public void deletePerson(Integer personid) {        
        Person person = em.find(Person.class, personid);
        if (person!=null) em.remove(person);
    }
}
