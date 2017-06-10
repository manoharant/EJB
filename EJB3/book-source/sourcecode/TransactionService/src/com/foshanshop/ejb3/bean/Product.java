package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 3614912777641452005L;
	private Integer productid;
    private String name; 
    private Float price;
    
    public Product() {}  
    
    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }
    
    @Id
    @GeneratedValue
    public Integer getProductid() {
        return productid;
    }
    public void setProductid(Integer productid) {
        this.productid = productid;
    }  
     
    @Column(nullable=false,length=50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(nullable=false)
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.productid != null ? this.productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product)object;
        if (this.productid != other.productid && (this.productid == null || !this.productid.equals(other.productid))) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ "[productid=" + productid + "]";
    } 
}
