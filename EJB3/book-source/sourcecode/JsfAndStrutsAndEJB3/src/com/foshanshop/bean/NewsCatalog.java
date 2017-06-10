package com.foshanshop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
/**
 * 新闻目录
 */
@Entity
public class NewsCatalog implements Serializable{
	private static final long serialVersionUID = 4925035130300057525L;
	private Integer catid;
	private String name;
	private Set<News> news = new HashSet<News>(); //该目录下的信息集合
	
	public NewsCatalog() {}
	
	public NewsCatalog(Integer catid) {
		this.catid = catid;
	}
	
	public NewsCatalog(String name) {
		this.name = name;
	}

	@Id @GeneratedValue  
	public Integer getCatid() {
		return catid;
	}
	public void setCatid(Integer catid) {
		this.catid = catid;
	}
	
	@Column(nullable=false,length=100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    @OneToMany(mappedBy="catalog",cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @OrderBy(value = "newsid desc")
    public Set<News> getNews() {
		return news;
	}
	public void setNews(Set<News> news) {
		this.news = news;
	}
	
	public void addNews(News news){
		if(!this.news.contains(news)){
			news.setCatalog(this);
			this.news.add(news);
		}
	}
	/**
     * 返回对象的散列代码值。该实现根据此对象
     * 中 catid 字段计算散列代码值。
     * @return 此对象的散列代码值。
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.catid != null ? this.catid.hashCode() : 0);
        return hash;
    }

    /**
     * 确定其他对象是否等于此 NewsCatalog。当且仅当
     * 参数不为 null 且该参数是具有与此对象相同 catid 字段值的 NewsCatalog 对象时，
     * 结果才为 <code>true</code>。
     * @param 对象，要比较的引用对象
     * 如果此对象与参数相同，则 @return <code>true</code>；
     * 否则为 <code>false</code>。
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NewsCatalog)) {
            return false;
        }
        NewsCatalog other = (NewsCatalog)object;
        if (this.catid != other.catid && (this.catid == null || !this.catid.equals(other.catid))) return false;
        return true;
    }

    /**
     * 返回对象的字符串表示法。该实现根据 catid 字段
     * 构造此表示法。
     * @return 对象的字符串表示法。
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[catid=" + catid + "]";
    }
}
