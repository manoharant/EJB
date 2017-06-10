package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.EntityInheritanceDAO;
import com.foshanshop.ejb3.bean.Car;
import com.foshanshop.ejb3.bean.Vehicle;
import com.foshanshop.ejb3.bean.Camion;

@Stateless
@Remote (EntityInheritanceDAO.class)
public class EntityInheritanceDAOBean implements EntityInheritanceDAO {
    @PersistenceContext protected EntityManager em;
  
    public void initializeData(){
        //添加Vehicle
        Vehicle vehicle = new Vehicle();
            vehicle.setSpeed((short)100);
        em.persist(vehicle);
        //添加Car
        Car car = new Car();
            car.setSpeed((short)300);
            car.setEngine("A发动机");
        em.persist(car);
        //添加Camion
        Camion camion = new Camion();
            camion.setSpeed((short)200);
            camion.setEngine("B发动机");
            camion.setContainer("2吨集装箱");
        em.persist(camion);
    }
    
    @SuppressWarnings("unchecked")
	public List<Vehicle> getVehicle() { 
        //查询所有Vehicle时，因为它是最继承树中的根，查询结果会得到所有继承于Vehicle类的记录
        //转绎成的SQL片断：select * from Vehicle_Hierarchy      
        Query query = em.createQuery("select v from Vehicle v");
        return (List<Vehicle>)query.getResultList();
    } 

    @SuppressWarnings("unchecked")
    public List<Car> getCar() { 
        //查询所有Car时，除了得到Car类的记录，也会得到所有继承于Car类的记录
        //构造的SQL Where部分：where Discriminator in ('Car', 'Camion')
        Query query = em.createQuery("select c from Car c");
        return (List<Car>)query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Camion> getCamion() {        
        Query query = em.createQuery("select c from Camion c");
        return (List<Camion>)query.getResultList();
    }  
    
    public void deleteVehicle() {  
        //执行该操作会删除自身对应记录，还会删除所有继承Vehicle的记录，
        //因为它是最继承树中的根，就相当于清除整个表的数据
        Query query = em.createQuery("delete from Vehicle v");
        query.executeUpdate();
    }  
}