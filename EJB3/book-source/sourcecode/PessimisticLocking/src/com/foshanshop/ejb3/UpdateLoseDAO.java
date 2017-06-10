package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.User;

public interface UpdateLoseDAO {
	public void init(User user);
	public String payElectricityFee(int id);
	public String saveLaborage(int id);
	public String secondPayElectricityFee(int id);
	public String secondSaveLaborage(int id);
}
