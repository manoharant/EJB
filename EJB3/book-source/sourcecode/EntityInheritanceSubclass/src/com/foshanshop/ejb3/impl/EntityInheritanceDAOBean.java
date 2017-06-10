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
        //���Vehicle
        Vehicle vehicle = new Vehicle();
            vehicle.setSpeed((short)100);
        em.persist(vehicle);
        //���Car
        Car car = new Car();
            car.setSpeed((short)300);
            car.setEngine("A������");
        em.persist(car);
        //���Camion
        Camion camion = new Camion();
            camion.setSpeed((short)200);
            camion.setEngine("B������");
            camion.setContainer("2�ּ�װ��");
        em.persist(camion);
    }
    
    @SuppressWarnings("unchecked")
	public List<Vehicle> getVehicle() { 
        //��ѯ����Vehicleʱ����Ϊ������̳����еĸ�����ѯ�����õ����м̳���Vehicle��ļ�¼
        //ת��ɵ�SQLƬ�ϣ�select * from Vehicle_Hierarchy      
        Query query = em.createQuery("select v from Vehicle v");
        return (List<Vehicle>)query.getResultList();
    } 

    @SuppressWarnings("unchecked")
    public List<Car> getCar() { 
        //��ѯ����Carʱ�����˵õ�Car��ļ�¼��Ҳ��õ����м̳���Car��ļ�¼
        //�����SQL Where���֣�where Discriminator in ('Car', 'Camion')
        Query query = em.createQuery("select c from Car c");
        return (List<Car>)query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Camion> getCamion() {        
        Query query = em.createQuery("select c from Camion c");
        return (List<Camion>)query.getResultList();
    }  
    
    public void deleteVehicle() {  
        //ִ�иò�����ɾ�������Ӧ��¼������ɾ�����м̳�Vehicle�ļ�¼��
        //��Ϊ������̳����еĸ������൱����������������
        Query query = em.createQuery("delete from Vehicle v");
        query.executeUpdate();
    }  
}