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
        //Add Vehicle
        Vehicle vehicle = new Vehicle();
            vehicle.setSpeed((short)100);
        em.persist(vehicle);
        //Add Car
        Car car = new Car();
            car.setSpeed((short)300);
            car.setEngine("A Engine");
        em.persist(car);
        //Add Camion
        Camion camion = new Camion();
            camion.setSpeed((short)200);
            camion.setEngine("B Engine");
            camion.setContainer("2 tons of container");
        em.persist(camion);
    }
    
    @SuppressWarnings("unchecked")
	public List<Vehicle> getVehicle() { 
        //Discover all Vehicle, since it is the root of the inheritance tree, the query result will be that all classes inherit from Vehicle record
        //Yi turn into a SQL snippet: select * from Vehicle_Hierarchy   
        Query query = em.createQuery("select v from Vehicle v");
        return (List<Vehicle>)query.getResultList();
    } 

    @SuppressWarnings("unchecked")
    public List<Car> getCar() { 
        //Discover all Car, in addition to records obtained Car class will get all records inherited from the Car class
        //SQL Where part structure: where Discriminator in ('Car', 'Camion')
        Query query = em.createQuery("select c from Car c");
        return (List<Car>)query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Camion> getCamion() {        
        Query query = em.createQuery("select c from Camion c");
        return (List<Camion>)query.getResultList();
    }  
    
    public void deleteVehicle() {  
        //Perform the operation deletes the corresponding record itself, also removes all inherited Vehicle records,
        //Because it is the root of the inheritance tree, it is equivalent to the entire table to clear the data
        Query query = em.createQuery("delete from Vehicle v");
        query.executeUpdate();
    }  
}