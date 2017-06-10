package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "Address", 
		pkJoinColumns = {@PrimaryKeyJoinColumn(name = "address_id")})
public class MainTable implements Serializable{
	private static final long serialVersionUID = 4016777473296175005L;
	private Integer id;// 主键
	private String name;// 姓名
	private String address;// 地址，该映射的字段分布在Address表
	private String postcode;// 邮编，该映射的字段分布在Address表

    @Id 
    @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(nullable=false,length=32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(table="Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(length=6, table="Address")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MainTable)) {
            return false;
        }
        MainTable other = (MainTable)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ "[id="+id+ ",name="+ name+ ",address="+ address+ ",postcode="+ postcode + "]";
    }
}
