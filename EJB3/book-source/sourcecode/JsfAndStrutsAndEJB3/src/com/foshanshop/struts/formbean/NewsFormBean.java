package com.foshanshop.struts.formbean;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class NewsFormBean extends ActionForm{
	private static final long serialVersionUID = 5585830825063765659L;
	private Integer newsid;
    /** ���ű��� **/
    private String title;
    /** �������� **/
    private String content;
    /** �������� **/
    private Date createdate;
    /** ������Դ **/
    private String source;
    /** ��ʼ���� **/
    private int firstResult;
    /** ��ȡ��¼�� **/
    private int maxResult;
    /** Ŀ¼ID **/
    private Integer catid;
    /** Ŀ¼���� **/
    private String catalogname;
    
    public String getCatalogname() {
		return catalogname;
	}
	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}
	public Integer getCatid() {
		return catid;
	}
	public void setCatid(Integer catid) {
		this.catid = catid;
	}
	public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    public int getFirstResult() {
        return firstResult;
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
    public Integer getNewsid() {
        return newsid;
    }
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
