package com.foshanshop.ejb3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Camion extends Car{
	private static final long serialVersionUID = -1266718346507357439L;
	private String container;//��װ��

    @Column(nullable=true,length=30)
    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }    
}
