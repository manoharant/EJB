package com.foshanshop.ejb3;

import java.util.List;

import com.foshanshop.ejb3.bean.Order;

public interface OrderDAO {
    /**
     * 添加一个订单
     *
     */
    public void insertOrder(Order order);
    /**
     * 获取指定订单
     * @param orderid 订单号
     * @return
     */
    public Order getOrderByID(Integer orderid);
    /**
     * 获取所有订单
     * @return
     */
    public List<Order> getAllOrder();
}
