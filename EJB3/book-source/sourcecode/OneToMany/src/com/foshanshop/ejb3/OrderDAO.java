package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Order;

public interface OrderDAO {
    /**
     * ���һ������
     *
     */
    public void insertOrder(Order order);
    /**
     * ��ȡָ������
     * @param orderid ������
     * @return
     */
    public Order getOrderByID(Integer orderid);
    /**
     * ��ȡ���ж���
     * @return
     */
    public List<Order> getAllOrder();
}
