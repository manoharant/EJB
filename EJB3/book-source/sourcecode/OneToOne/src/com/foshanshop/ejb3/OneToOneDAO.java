package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Person;

public interface OneToOneDAO {
	/**
	 * ���һ����
	 * @param person ��Ա
	 */
    public void insertPerson(Person person);
    /**
     * ��ȡָ����Ա
     * @param orderid ��Աid
     * @return
     */
    public Person getPersonByID(Integer orderid);
    /**
     * ������Ա����,���֤����
     * @param personid ��Աid
     * @param newname ������
     * @param newIDcard �����֤����
     */
    public void updatePersonInfo(Integer personid, String newname, String newIDcard);
    /**
     * ɾ��ָ����Ա,��Ϊ���˼���ɾ��,����ͬ���֤һ��ɾ��
     * @param personid ��Աid
     */
    public void deletePerson(Integer personid);
}
