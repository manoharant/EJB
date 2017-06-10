package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="CarID")
public class Car extends Vehicle{
	private static final long serialVersionUID = -8744304233821634737L;
	private String engine;//·¢¶¯»ú

    @Column(nullable=true,length=30)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
