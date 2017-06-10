package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person  implements Serializable{
	private static final long serialVersionUID = -7090476760197665776L;
	private Integer personid;
    private String name;    
    private boolean sex;
    private Short age;
    private Date birthday;
    private Set<Order> orders = new HashSet<Order>();
    
    public Person(){}
    public Person(String name, boolean sex, Short age, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }
    
    @Id
    @GeneratedValue   
    public Integer getPersonid() {
        return personid;
    }
    public void setPersonid(Integer personid) {
        this.personid = personid;
    } 
    
    @Column(name = "PersonName",nullable=false,length=32)
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
    
    @OneToMany(mappedBy="ower",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "orderid ASC")
    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    
    /**
     * 返回对象的散列代码值。该实现根据此对象
     * 中 personid 字段计算散列代码值。
     * @return 此对象的散列代码值。
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.personid != null ? this.personid.hashCode() : super.hashCode());
        return hash;
    }

    /**
     * 确定其他对象是否等于此 Person。当且仅当
     * 参数不为 null 且该参数是具有与此对象相同 personid 字段值的 Person 对象时，
     * 结果才为 <code>true</code>。
     * @param 对象，要比较的引用对象
     * 如果此对象与参数相同，则 @return <code>true</code>；
     * 否则为 <code>false</code>。
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person)object;
        if (this.personid != other.personid && (this.personid == null || !this.personid.equals(other.personid))) return false;
        return true;
    }

    /**
     * 返回对象的字符串表示法。该实现根据 personid 字段
     * 构造此表示法。
     * @return 对象的字符串表示法。
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[personid=" + personid+ "]";
    }
}
