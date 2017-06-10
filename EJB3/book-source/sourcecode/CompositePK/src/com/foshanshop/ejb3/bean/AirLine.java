package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class AirLine implements Serializable {
	private static final long serialVersionUID = -515855962558721968L;
	private AirtLinePK id;
    private Boolean onoff;
    private Set<Flight> flights = new HashSet<Flight>();

    public AirLine(){}
    
    public AirLine(AirtLinePK id, Boolean onoff){
        this.id = id;   
        this.onoff = onoff;
    }

    @EmbeddedId
    public AirtLinePK getId() {
        return id;
    }
    public void setId(AirtLinePK id) {
        this.id = id;
    }

    public Boolean getOnoff() {
        return onoff;
    }

    public void setOnoff(Boolean onoff) {
        this.onoff = onoff;
    }

    @OneToMany(mappedBy="airline",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    } 

    public void addFlight(Flight flight) {
        if (!this.flights.contains(flight)) {
             this.flights.add(flight);
             flight.setAirline(this);
        }
    }

    public void removeFlight(Flight flight) {
        if (this.flights.contains(flight)) {
            this.flights.remove(flight);
       }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AirLine)) {
            return false;
        }
        AirLine other = (AirLine)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ "[id=" + id + "]";
    }
}
