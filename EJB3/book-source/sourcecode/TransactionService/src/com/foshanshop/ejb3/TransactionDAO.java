package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Product;

public interface TransactionDAO {
	public void systemException();
	public void AppException() throws AppException ; 
    public void setRollback();
    public void requried_notInTransaction();
    public void requried_inTransaction();
    public Product notSupported_runInTransaction(Product product);
    public void mandatory_inTransaction();
    public void mandatory_notInTransaction();
    public void requirednew_inTransaction();
    public void requirednew_notInTransaction();
    public Product support_inTransaction();
    public Product support_notInTransaction();
    public Product never_inTransaction(int productid);
    public Product never_notInTransaction(int productid);
}
