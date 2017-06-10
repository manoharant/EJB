package com.foshanshop.ejb3.bean;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 4970325922198249712L;
	private Integer orderid;
    private Float amount;
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();
    private Date createdate;

    @Id
    @GeneratedValue  
    public Integer getOrderid() {
        return orderid;
    }
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
    
    public Float getAmount() {
        return amount;
    }    
    public void setAmount(Float amount) {
        this.amount = amount;
    }
    
    @OneToMany(mappedBy="order",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    
    public void addOrderItem(OrderItem orderitem) {
       if (!this.orderItems.contains(orderitem)) {
            this.orderItems.add(orderitem);
            orderitem.setOrder(this);
       }
    }

    public void removeOrderItem(OrderItem orderitem) {
        if (this.orderItems.contains(orderitem)) {
            orderitem.setOrder(null);
            this.orderItems.remove(orderitem);
        }
    }
    
    /**
     * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶���
     * �� orderid �ֶμ���ɢ�д���ֵ��
     * @return �˶����ɢ�д���ֵ��
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.orderid != null ? this.orderid.hashCode() : 0);
        return hash;
    }

    /**
     * ȷ�����������Ƿ���ڴ� Order�����ҽ���
     * ������Ϊ null �Ҹò����Ǿ�����˶�����ͬ orderid �ֶ�ֵ�� Order ����ʱ��
     * �����Ϊ <code>true</code>��
     * @param ����Ҫ�Ƚϵ����ö���
     * ����˶����������ͬ���� @return <code>true</code>��
     * ����Ϊ <code>false</code>��
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order)object;
        if (this.orderid != other.orderid && (this.orderid == null || !this.orderid.equals(other.orderid))) return false;
        return true;
    }

    /**
     * ���ض�����ַ�����ʾ������ʵ�ָ��� orderid �ֶ�
     * ����˱�ʾ����
     * @return ������ַ�����ʾ����
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[orderid=" + orderid + "]";
    }
}
