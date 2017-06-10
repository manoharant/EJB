package com.foshanshop.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import com.foshanshop.ejb3.LocalOperation;
import com.foshanshop.ejb3.Operation;

@Stateless
@Remote (Operation.class)
@Local (LocalOperation.class)
public class OperationBean implements Operation, LocalOperation {
    private int total = 0;
    
    public int Addup() {
    	total++;
    	return total;
    }
}
