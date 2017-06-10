package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.EntityLifecycle;

public interface EntityLifecycleDAO {    
    public void Persist(); 
    public EntityLifecycle Load(); 
    public void Update(); 
    public void Remove(); 
}
