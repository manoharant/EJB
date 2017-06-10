package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Camion;
import com.foshanshop.ejb3.bean.Car;
import com.foshanshop.ejb3.bean.Vehicle;

public interface EntityInheritanceDAO {
	/**
	 * ��ʼ������
	 *
	 */
    public void initializeData(); 
    /**
     * ��ȡȫ��Vehicle
     * @return
     */
    public List<Vehicle> getVehicle();  
    /**
     * ��ȡȫ��Car
     * @return
     */
    public List<Car> getCar() ;
    /**
     * ��ȡȫ��Camion
     * @return
     */
    public List<Camion> getCamion();
    /**
     * ɾ������Vehicle
     *
     */
    public void deleteVehicle();
}
