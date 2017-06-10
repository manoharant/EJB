package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.User;

public interface LockingDAO {
	public void payElectricityFee(int id);
	public void saveLaborage(int id);
	public void init(User user);
}
