package com.foshanshop.utils;

public class Page {
    /** ��ʼ���� **/
    private int firstResult;
    /** ��ȡ��¼�� **/
    private int maxResult;
    /** ��ҳ�� **/
    private long totalpage;
    /** ��ǰҳ **/
    private int currentpage;

    public Page(){}
    
	public Page(int firstResult, int maxResult) {
		this.firstResult = firstResult;
		this.maxResult = maxResult;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public long getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
	}
	/**
	 * ������ҳ������ǰҳ
	 * @param recordtotal ��¼����
	 */
	public void calculate(long recordtotal){
        if(recordtotal>0){
            if(recordtotal%this.getMaxResult()==0){
            	this.setTotalpage(recordtotal/this.getMaxResult());
            }else{
            	this.setTotalpage(1+ recordtotal/this.getMaxResult());
            }
            if(this.getFirstResult()==0 || this.getFirstResult()>=recordtotal){
            	this.setCurrentpage(1);
            }else{
            	this.setCurrentpage(this.getFirstResult()/this.getMaxResult()+1);
            }
        }else{
        	this.setTotalpage(0);
        	this.setCurrentpage(0);
        }
	}
}
