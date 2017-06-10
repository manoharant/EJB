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
    
    @SuppressWarnings("unchecked")//�ر�unchecked����
	public List<Person> getPersonList() {
    	//��Ŀǰ��weblogic10.3�汾�������ָ��select��ѯǰ׺�����д��from Person order by personid asc���ᱨ��
        Query query = em.createQuery("select p from Person p order by p.personid asc");
        return (List<Person>) query.getResultList();
    }
}
