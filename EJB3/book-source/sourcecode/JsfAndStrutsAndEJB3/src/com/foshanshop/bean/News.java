package com.foshanshop.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * ����
 */
@Entity
public class News implements Serializable{
	private static final long serialVersionUID = -2740433053098129461L;
	/** ����ID **/
    private Integer newsid;
    /** ���ű��� **/
    private String title;
    /** �������� **/
    private String content;
    /** �������� **/
    private Date createdate;
    /** ������Դ **/
    private String source;
    private NewsCatalog catalog;
    
    public News(){}
    
    public News(String title) {
        this.title = title;
    }
    
    @Id @GeneratedValue  
    public Integer getNewsid() {
        return newsid;
    }
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }
    
    @Column(nullable=false,length=100)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Lob
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    
    @Column(length=50)
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    @ManyToOne(cascade=CascadeType.REFRESH, optional=false)
    @JoinColumn(name = "cat_id", nullable=false) 
    public NewsCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(NewsCatalog catalog) {
		this.catalog = catalog;
	}

	/**
     * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶���
     * �� newsid �ֶμ���ɢ�д���ֵ��
     * @return �˶����ɢ�д���ֵ��
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.newsid != null ? this.newsid.hashCode() : super.hashCode());
        return hash;
    }

    /**
     * ȷ�����������Ƿ���ڴ� News�����ҽ���
     * ������Ϊ null �Ҹò����Ǿ�����˶�����ͬ newsid �ֶ�ֵ�� News ����ʱ��
     * �����Ϊ <code>true</code>��
     * @param ����Ҫ�Ƚϵ����ö���
     * ����˶����������ͬ���� @return <code>true</code>��
     * ����Ϊ <code>false</code>��
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News)object;
        if (this.newsid != other.newsid && (this.newsid == null || !this.newsid.equals(other.newsid))) return false;
        return true;
    }

    /**
     * ���ض�����ַ�����ʾ������ʵ�ָ��� newsid �ֶ�
     * ����˱�ʾ����
     * @return ������ַ�����ʾ����
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[newsid=" + newsid + "]";
    }
}
