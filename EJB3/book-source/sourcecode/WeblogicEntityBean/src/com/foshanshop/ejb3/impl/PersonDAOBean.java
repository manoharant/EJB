package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.PersonDAO;
import com.foshanshop.ejb3.PersonDAOLocal;
import com.foshanshop.ejb3.bean.Person;

@Stateless(mappedName="PersonDAOBean")
@Remote (PersonDAO.class)
@Local (PersonDAOLocal.class)
public class PersonDAOBean implements PersonDAO,PersonDAOLocal{
    @PersistenceContext protected EntityManager em;

    public void insertPerson(Person person) {
        em.persist(person);
    }
    
    @SuppressWarnings("unchecked")//关闭unchecked警告
	public List<Person> getPersonList() {
    	//在目前的weblogic10.3版本，你必须指定select查询前缀，如果写成from Person order by personid asc将会报错
        Query query = em.createQuery("select p from Person p order by p.personid asc");
        return (List<Person>) query.getResultList();
    }
}
