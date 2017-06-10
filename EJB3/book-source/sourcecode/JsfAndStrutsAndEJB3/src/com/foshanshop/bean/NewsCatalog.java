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
 * ����Ŀ¼
 */
@Entity
public class NewsCatalog implements Serializable{
	private static final long serialVersionUID = 4925035130300057525L;
	private Integer catid;
	private String name;
	private Set<News> news = new HashSet<News>(); //��Ŀ¼�µ���Ϣ����
	
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
     * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶���
     * �� catid �ֶμ���ɢ�д���ֵ��
     * @return �˶����ɢ�д���ֵ��
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.catid != null ? this.catid.hashCode() : 0);
        return hash;
    }

    /**
     * ȷ�����������Ƿ���ڴ� NewsCatalog�����ҽ���
     * ������Ϊ null �Ҹò����Ǿ�����˶�����ͬ catid �ֶ�ֵ�� NewsCatalog ����ʱ��
     * �����Ϊ <code>true</code>��
     * @param ����Ҫ�Ƚϵ����ö���
     * ����˶����������ͬ���� @return <code>true</code>��
     * ����Ϊ <code>false</code>��
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
     * ���ض�����ַ�����ʾ������ʵ�ָ��� catid �ֶ�
     * ����˱�ʾ����
     * @return ������ַ�����ʾ����
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[catid=" + catid + "]";
    }
}
