package com.foshanshop.jsf;

import com.foshanshop.bean.News;
import com.foshanshop.dao.NewsLocalDAO;
import com.foshanshop.utils.EJBFactory;
/**
 * 单条新闻查看
 * @author lihuoming
 *
 */
public class View {
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public News getNews() {
        NewsLocalDAO newsdao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
        News news = newsdao.find(News.class, this.id);
		return news;
	}
}
