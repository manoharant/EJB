package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.AirLine;

public interface AirLineDAO {
	/**
	 *
	 *
	 */
    public void insertAirLine();
    /**
     * @param leavecity
     * @param arrivecity
     * @return
     */
    public AirLine getAirLineByID(String leavecity, String arrivecity);
}
