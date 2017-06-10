package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle{
	private static final long serialVersionUID = -8744304233821634737L;
	private String engine;

    @Column(nullable=true,length=30)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
