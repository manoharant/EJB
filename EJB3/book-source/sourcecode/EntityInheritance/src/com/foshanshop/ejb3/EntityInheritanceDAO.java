package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Camion;
import com.foshanshop.ejb3.bean.Car;
import com.foshanshop.ejb3.bean.Vehicle;

public interface EntityInheritanceDAO {
	public void initializeData(); 
    public List<Vehicle> getVehicle();  
    public List<Car> getCar() ;
    public List<Camion> getCamion();
    public void deleteVehicle();
}
