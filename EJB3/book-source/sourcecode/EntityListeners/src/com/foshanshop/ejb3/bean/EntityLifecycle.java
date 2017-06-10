package com.foshanshop.ejb3.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.foshanshop.ejb3.bean.listener.EntityListenerLogger;

@Entity
@EntityListeners({EntityListenerLogger.class})
public class EntityLifecycle implements Serializable{
    private static final long serialVersionUID = 2619167645480125649L;
    private Integer id;
    private String name; 
  
    public EntityLifecycle() {}
    
    public EntityLifecycle(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable=false,length=32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
