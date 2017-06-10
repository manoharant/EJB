package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Camion")
public class Camion extends Car{
	private static final long serialVersionUID = -1266718346507357439L;
	private String container;

    @Column(nullable=true,length=30)
    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }    
}
