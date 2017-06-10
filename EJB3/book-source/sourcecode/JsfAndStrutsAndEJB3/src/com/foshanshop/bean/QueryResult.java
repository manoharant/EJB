package com.foshanshop.bean;

import java.io.Serializable;
import java.util.List;
/**
 * ��װ��ѯ���
 *
 */
public class QueryResult implements Serializable {
    private static final long serialVersionUID = -4932101157119853062L;
    private long recordtotal; //��¼����
    private List<?> resultset; //��ѯ�����

    public QueryResult(){
        this.recordtotal = 0;
        this.resultset = null;
    }
    
    public QueryResult(List<?> resultset) {
        this.recordtotal = 0;
        this.resultset = resultset;
    }
    
    public QueryResult(long recordtotal, List<?> resultset) {
        this.recordtotal = recordtotal;
        this.resultset = resultset;
    }

    public long getRecordtotal() {
        return recordtotal;
    }

    public void setRecordtotal(long recordtotal) {
        this.recordtotal = recordtotal;
    }

    public List<?> getResultset() {
        return resultset;
    }

    public void setResultset(List<?> resultset) {
        this.resultset = resultset;
    }   
}
