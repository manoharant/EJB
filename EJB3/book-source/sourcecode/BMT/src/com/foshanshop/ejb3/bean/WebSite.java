package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WebSite implements Serializable {
	private static final long serialVersionUID = 5958300862252228624L;
	private Integer id;
    private String name; 
    private String url;
    
    public WebSite() {}  

	public WebSite(String name, String url) {
		this.name = name;
		this.url = url;
	}

	@Id @GeneratedValue
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
    @Column(nullable=false,length=50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
	@Column(nullable=false,length=200)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof WebSite)) {
            return false;
        }
        WebSite other = (WebSite)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ "[id=" + id + "]";
    } 
}
