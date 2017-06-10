package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Person")
public class Person implements Serializable{
	private static final long serialVersionUID = -3491146776554220574L;
	private Integer personid;
    private String name;    
    private boolean sex;
    private Short age;
    private Date birthday;
  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getPersonid() {
        return personid;
    }
    public void setPersonid(Integer personid) {
        this.personid = personid;
    } 
    
    @Column(nullable=false,length=32)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(nullable=false)
    public boolean getSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    @Column(nullable=false)   
    public Short getAge() {
        return age;
    }
    public void setAge(Short age) {
        this.age = age;
    } 
    
    @Temporal(value=TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
