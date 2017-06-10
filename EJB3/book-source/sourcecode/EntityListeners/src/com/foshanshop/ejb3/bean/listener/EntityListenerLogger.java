package com.foshanshop.ejb3.bean.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EntityListenerLogger {
 
    @PostLoad
    public void postLoad(Object entity) {
        System.out.println("{" + entity.getClass().getName( ) + "}");
    }
    
    @PrePersist
    public void PreInsert(Object entity) {
        System.out.println("{" + entity.getClass().getName( )+ "}");
    }
    
    @PostPersist
    public void postInsert(Object entity) {
        System.out.println("{" + entity.getClass().getName( )+ "}");
    }

    @PreUpdate
    public void PreUpdate(Object entity) {
        System.out.println("{" + entity.getClass().getName( )+ "}");
    }
    
    @PostUpdate
    public void PostUpdate(Object entity) {
        System.out.println("{" + entity.getClass().getName( )+ "}");
    }

    @PreRemove
    public void PreRemove(Object entity) {
        System.out.println("{" + entity.getClass().getName( )+ "}");
    }
    
    @PostRemove
    public void PostRemove(Object entity) {
        System.out.println("{" + entity.getClass().getName( )+ "}");
    }
}
