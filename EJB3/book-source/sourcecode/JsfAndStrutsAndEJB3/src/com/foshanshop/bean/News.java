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
 * 新闻
 */
@Entity
public class News implements Serializable{
	private static final long serialVersionUID = -2740433053098129461L;
	/** 新闻ID **/
    private Integer newsid;
    /** 新闻标题 **/
    private String title;
    /** 新闻内容 **/
    private String content;
    /** 发布日期 **/
    private Date createdate;
    /** 新闻来源 **/
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
     * 返回对象的散列代码值。该实现根据此对象
     * 中 newsid 字段计算散列代码值。
     * @return 此对象的散列代码值。
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.newsid != null ? this.newsid.hashCode() : super.hashCode());
        return hash;
    }

    /**
     * 确定其他对象是否等于此 News。当且仅当
     * 参数不为 null 且该参数是具有与此对象相同 newsid 字段值的 News 对象时，
     * 结果才为 <code>true</code>。
     * @param 对象，要比较的引用对象
     * 如果此对象与参数相同，则 @return <code>true</code>；
     * 否则为 <code>false</code>。
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
     * 返回对象的字符串表示法。该实现根据 newsid 字段
     * 构造此表示法。
     * @return 对象的字符串表示法。
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[newsid=" + newsid + "]";
    }
}
