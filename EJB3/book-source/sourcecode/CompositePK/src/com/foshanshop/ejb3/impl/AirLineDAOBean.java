package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.AirLineDAO;
import com.foshanshop.ejb3.bean.AirLine;
import com.foshanshop.ejb3.bean.AirtLinePK;
import com.foshanshop.ejb3.bean.Flight;

@Stateless
@Remote (AirLineDAO.class)
public class AirLineDAOBean implements AirLineDAO {
    @PersistenceContext protected EntityManager em;
    
    public void insertAirLine() {
        Query query = em.createQuery("select count(a.id.leavecity) from AirLine a where a.id.leavecity =?1 and a.id.arrivecity=?2");
        query.setParameter(1, "PEK"); 
        query.setParameter(2, "CAN");
        int result = Integer.parseInt(query.getSingleResult().toString());
        if (result==0){
            AirLine airLine = new AirLine(new AirtLinePK("PEK","CAN"), true);
            
            airLine.addFlight(new Flight("CA1321","08:45","11:50"));
            airLine.addFlight(new Flight("CZ3102","12:05","15:05"));
            airLine.addFlight(new Flight("HU7801","15:05","17:45"));
            em.persist(airLine);
        }
    }

    public AirLine getAirLineByID(String leavecity, String arrivecity) {
        AirLine airLine =  em.find(AirLine.class, new AirtLinePK(leavecity,arrivecity));        
        airLine.getFlights().size();
        
        return airLine;
    }
}
