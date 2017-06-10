package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Camion;
import com.foshanshop.ejb3.bean.Car;
import com.foshanshop.ejb3.bean.Vehicle;

public interface EntityInheritanceDAO {
	/**
	 * 初始化数据
	 *
	 */
    public void initializeData(); 
    /**
     * 获取全部Vehicle
     * @return
     */
    public List<Vehicle> getVehicle();  
    /**
     * 获取全部Car
     * @return
     */
    public List<Car> getCar() ;
    /**
     * 获取全部Camion
     * @return
     */
    public List<Camion> getCamion();
    /**
     * 删除所有Vehicle
     *
     */
    public void deleteVehicle();
}
