package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AirtLinePK implements Serializable {
	private static final long serialVersionUID = -8430464367315480936L;
	private String leavecity;
    private String arrivecity;
    
    public AirtLinePK(){}
    
    public AirtLinePK(String leavecity, String arrivecity) {
        this.leavecity = leavecity;
        this.arrivecity = arrivecity;
    }

    @Column(nullable=false,length=3,name="LEAVECITY")
    public String getLeavecity() {
        return leavecity;
    }
    public void setLeavecity(String leavecity) {
        this.leavecity = leavecity;
    }
    
    @Column(nullable=false,length=3,name="ARRIVECITY")
    public String getArrivecity() {
        return arrivecity;
    }
    public void setArrivecity(String arrivecity) {
        this.arrivecity = arrivecity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.leavecity!=null && this.arrivecity!=null ? (this.leavecity+ "-"+ this.arrivecity).hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AirtLinePK)) {
            return false;
        }
        AirtLinePK other = (AirtLinePK)object;
        if (this.leavecity != other.leavecity && (this.leavecity == null || !this.leavecity.equalsIgnoreCase(other.leavecity))) return false;
        if (this.arrivecity != other.arrivecity && (this.arrivecity == null || !this.arrivecity.equalsIgnoreCase(other.arrivecity))) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"[leavecity="+ leavecity + ",arrivecity="+ arrivecity+ "]";
    }
    
}
