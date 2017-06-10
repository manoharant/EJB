package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Flight implements Serializable {
	private static final long serialVersionUID = 5224268726211078831L;
	private Integer id;  
    private String flightno;
    private String leavetime;
    private String arrivetime;
    private AirLine airline;
    
    public Flight(){}
 
    public Flight(String flightno, String leavetime, String arrivetime) {
        this.flightno = flightno;
        this.leavetime = leavetime;
        this.arrivetime = arrivetime;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(nullable=false,length=10)
    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }
    
    @Column(length=10)
    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }
    
    @Column(length=10)
    public String getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    @ManyToOne(cascade=CascadeType.REFRESH,optional=false)  
    @JoinColumns ({
        @JoinColumn(name="Leave_City", referencedColumnName = "LEAVECITY", nullable=false),
        @JoinColumn(name="Arrive_City", referencedColumnName = "ARRIVECITY", nullable=false)
        })  
    public AirLine getAirline() {
        return airline;
    }

    public void setAirline(AirLine airline) {
        this.airline = airline;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : super.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ "[id=" + id + "]";
    }
}
