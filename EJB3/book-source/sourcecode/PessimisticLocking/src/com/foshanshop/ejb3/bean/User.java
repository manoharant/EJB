package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{
	private static final long serialVersionUID = 2341426139465625710L;
	private Integer id;
	private Integer balance;
	
	public User() {}

	public User(Integer balance) {
		this.balance = balance;
	}

	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : super.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ "[id=" + id + "]";
    }
}
