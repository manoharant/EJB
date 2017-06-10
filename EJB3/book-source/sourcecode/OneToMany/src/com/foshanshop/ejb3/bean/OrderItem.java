package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem implements Serializable {

	private static final long serialVersionUID = -1166337687856636179L;
	private Integer id;
    private String productname;
    private Float price;
    private Order order;
    
    public OrderItem() {}
 
    public OrderItem(String productname, Float price) {
        this.productname = productname;
        this.price = price;
    }

    @Id
    @GeneratedValue 
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    } 
    
    @Column(length=100, nullable=false)
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
    @ManyToOne(cascade=CascadeType.REFRESH, optional=false)
    @JoinColumn(name = "order_id")  
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    
    /**
     * 返回对象的散列代码值。该实现根据此对象
     * 中 id 字段计算散列代码值。
     * @return 此对象的散列代码值。
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : super.hashCode());
        return hash;
    }

    /**
     * 确定其他对象是否等于此 OrderItem。当且仅当
     * 参数不为 null 且该参数是具有与此对象相同 id 字段值的 OrderItem 对象时，
     * 结果才为 <code>true</code>。
     * @param 对象，要比较的引用对象
     * 如果此对象与参数相同，则 @return <code>true</code>；
     * 否则为 <code>false</code>。
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * 返回对象的字符串表示法。该实现根据 id 字段
     * 构造此表示法。
     * @return 对象的字符串表示法。
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[id=" + id + "]";
    }
}
