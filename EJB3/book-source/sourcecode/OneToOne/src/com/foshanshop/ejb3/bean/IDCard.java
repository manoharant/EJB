package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IDCard  implements Serializable{
	private static final long serialVersionUID = -4610000117411667607L;
	private Integer id;
    private String cardno;    
    private Person person;
  
    public IDCard() {}
    
    public IDCard(String cardno) {
        this.cardno = cardno;
    }
    
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(nullable=false,length=18,unique = true)
    public String getCardno() {
        return cardno;
    }
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
    
    @OneToOne(optional = false, cascade = CascadeType.REFRESH, mappedBy = "idcard")
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    /**
     * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶���
     * �� id �ֶμ���ɢ�д���ֵ��
     * @return �˶����ɢ�д���ֵ��
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * ȷ�����������Ƿ���ڴ� IDCard�����ҽ���
     * ������Ϊ null �Ҹò����Ǿ�����˶�����ͬ id �ֶ�ֵ�� IDCard ����ʱ��
     * �����Ϊ <code>true</code>��
     * @param ����Ҫ�Ƚϵ����ö���
     * ����˶����������ͬ���� @return <code>true</code>��
     * ����Ϊ <code>false</code>��
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IDCard)) {
            return false;
        }
        IDCard other = (IDCard)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * ���ض�����ַ�����ʾ������ʵ�ָ��� id �ֶ�
     * ����˱�ʾ����
     * @return ������ַ�����ʾ����
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[id=" + id + "]";
    } 
}
