package com.foshanshop.ejb3;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class AppException extends Exception {
	private static final long serialVersionUID = -5072144274496513571L;

	public AppException (String message) { 
        super(message);
    }
}
