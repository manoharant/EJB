package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.OrderDAO;
import com.foshanshop.ejb3.bean.Order;

@Stateless
@Remote (OrderDAO.class)
public class OrderDAOBean implements OrderDAO {
    @PersistenceContext protected EntityManager em;
    
    public void insertOrder(Order order){
        em.persist(order);
    }

    public Order getOrderByID(Integer orderid) {
       Order order =  em.find(Order.class, orderid);
       order.getOrderItems().size();
       //因为是延迟加载，通过执行size()这种方式获取订单下的所有订单项
       return order;
    }

    @SuppressWarnings("unchecked")
	public List<Order> getAllOrder() {
        Query query = em.createQuery("select DISTINCT o from Order o inner join fetch o.orderItems order by o.orderid");
        return (List<Order>) query.getResultList();
    }
}
