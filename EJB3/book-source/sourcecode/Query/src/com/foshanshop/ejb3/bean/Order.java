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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 686643084215220968L;
	private Integer orderid;
    private Float amount;
    private Person ower;
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();
    private Date createdate;
    
    public Order(){}
    public Order(Float amount, Person ower, Date createdate) {
        this.amount = amount;
        this.ower = ower;
        this.createdate = createdate;
    }
    
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
 
    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name = "person_id")    
    public Person getOwer() {
        return ower;
    }
    public void setOwer(Person ower) {
        this.ower = ower;
    }

    @OneToMany(mappedBy="order",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
    
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }  
    /**
     * 返回对象的散列代码值。该实现根据此对象
     * 中 orderid 字段计算散列代码值。
     * @return 此对象的散列代码值。
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.orderid != null ? this.orderid.hashCode() : super.hashCode());
        return hash;
    }

    /**
     * 确定其他对象是否等于此 Order。当且仅当
     * 参数不为 null 且该参数是具有与此对象相同 orderid 字段值的 Order 对象时，
     * 结果才为 <code>true</code>。
     * @param 对象，要比较的引用对象
     * 如果此对象与参数相同，则 @return <code>true</code>；
     * 否则为 <code>false</code>。
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
     * 返回对象的字符串表示法。该实现根据 orderid 字段
     * 构造此表示法。
     * @return 对象的字符串表示法。
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[orderid=" + orderid + "]";
    }
}
