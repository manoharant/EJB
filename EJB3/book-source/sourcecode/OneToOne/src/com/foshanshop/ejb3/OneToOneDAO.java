package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Person;

public interface OneToOneDAO {
	/**
	 * 添加一个人
	 * @param person 人员
	 */
    public void insertPerson(Person person);
    /**
     * 获取指定人员
     * @param orderid 人员id
     * @return
     */
    public Person getPersonByID(Integer orderid);
    /**
     * 更新人员姓名,身份证号码
     * @param personid 人员id
     * @param newname 新姓名
     * @param newIDcard 新身份证号码
     */
    public void updatePersonInfo(Integer personid, String newname, String newIDcard);
    /**
     * 删除指定人员,因为设了级联删除,会连同身份证一起删除
     * @param personid 人员id
     */
    public void deletePerson(Integer personid);
}
