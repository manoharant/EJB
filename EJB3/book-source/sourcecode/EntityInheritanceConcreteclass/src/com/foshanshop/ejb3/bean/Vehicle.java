package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle implements Serializable{
	private static final long serialVersionUID = -3196397365804550797L;
	private Long id;
    private Short speed;//Speed
    
    @Id
    @TableGenerator(name="VehicleID_Generator",//Generation method for taking a name
            table="VehicleID_Generator",//Table definition used to generate ID's
            pkColumnName="PRIMARY_KEY_COLUMN",//Name of the primary key fields
            valueColumnName="VALUE_COLUMN",//Storage field generated ID values
            pkColumnValue="vehicle",//Primary key field value (the value used to locate a record, then accumulate its ID value)
            allocationSize=1 
            )
    @GeneratedValue(strategy=GenerationType.TABLE, generator="VehicleID_Generator")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Short getSpeed() {
        return speed;
    }
    public void setSpeed(Short speed) {
        this.speed = speed;
    }    
}
