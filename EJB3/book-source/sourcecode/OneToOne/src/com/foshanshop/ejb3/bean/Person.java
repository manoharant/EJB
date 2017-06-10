package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person  implements Serializable{
	private static final long serialVersionUID = 8305710085432450318L;
	private Integer personid;
    private String name;    
    private boolean sex;
    private Short age;
    private Date birthday;
    private IDCard idcard;
  
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
 
    @OneToOne(optional = true, cascade = CascadeType.ALL)  
    @JoinColumn(name = "idcard_id", unique = true)  
    public IDCard getIdcard() {
        return idcard;   
    }   
    public void setIdcard(IDCard idcard) {  
        this.idcard = idcard;   
    } 
    /**
     * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶���
     * �� personid �ֶμ���ɢ�д���ֵ��
     * @return �˶����ɢ�д���ֵ��
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.personid != null ? this.personid.hashCode() : 0);
        return hash;
    }

    /**
     * ȷ�����������Ƿ���ڴ� Person�����ҽ���
     * ������Ϊ null �Ҹò����Ǿ�����˶�����ͬ personid �ֶ�ֵ�� Person ����ʱ��
     * �����Ϊ <code>true</code>��
     * @param ����Ҫ�Ƚϵ����ö���
     * ����˶����������ͬ���� @return <code>true</code>��
     * ����Ϊ <code>false</code>��
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
     * ���ض�����ַ�����ʾ������ʵ�ָ��� personid �ֶ�
     * ����˱�ʾ����
     * @return ������ַ�����ʾ����
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[personid=" + personid+ "]";
    }
}
