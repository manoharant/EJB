package com.foshanshop.jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.LinkedHashMap;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.foshanshop.bean.News;
import com.foshanshop.bean.NewsCatalog;
import com.foshanshop.dao.CatalogLocalDAO;
import com.foshanshop.dao.NewsLocalDAO;
import com.foshanshop.utils.EJBFactory;
import com.foshanshop.utils.Page;
/**
 * JSF框架 新闻添/删/改类
 * @author lihuoming
 *
 */
public class NewsAction extends Page{
	/** 输入/输出 **/
	private News news;
    /** 目录下选择框 **/
    private List<SelectItem> selectItems;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public News getNews() {
		return news;
	}	
    public NewsAction(){
    	this.news = new News();
    	NewsCatalog cat = new NewsCatalog();
    	cat.addNews(this.news);
    }
	/**
	 * 初始化新闻添加界面的目录字段
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SelectItem> getSelectItems() {
		if(this.selectItems==null){
	    	CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
	    	LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
	        orderBy.put("catid", "DESC");
	    	List<NewsCatalog> catalogs = (List<NewsCatalog>) dao.getResultList(NewsCatalog.class, -1, -1, orderBy).getResultset();
	    	this.selectItems = new ArrayList<SelectItem>(catalogs.size());
	    	for(NewsCatalog catalog : catalogs){
	    		selectItems.add(new SelectItem(catalog.getCatid(), catalog.getName()));
	    	}
    	}
		return selectItems;
	}
	/**
	 * 获取目录的数量
	 * @return
	 */
	public int getSelectItemsSize() {
    	if(this.selectItems==null) this.getSelectItems();
    	return this.selectItems.size();
	}
    /**
     * 添加新闻
     */
    public String add() {
    	CatalogLocalDAO catdao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        this.news.setCreatedate(new Date());
        if(this.news.getCatalog().getCatid()!=null && this.news.getCatalog().getCatid()>0){//如果目录已经存在
            NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
            dao.save(news);//保存新闻
        }else{
        	catdao.save(this.news.getCatalog());//保存目录时，级联保存新闻
        }
        this.messageshow("保存成功");
        return "print";
    }
    
    /**
     * 删除新闻
     */
    public String delete() {
        NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO"); 
        dao.delete(News.class, this.id);
        this.messageshow("删除成功");
        return "print";
    }
    /**
     * 修改新闻界面
     */
    public String editUI(){
    	NewsLocalDAO newsdao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
    	this.news = newsdao.find(News.class, this.id);
    	return "edit";
    }
    /**
     * 修改新闻
     */
    public String edit(){        
        NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO"); 
        News entity = dao.find(News.class, news.getNewsid());       
        entity.setContent(news.getContent());
        entity.setTitle(news.getTitle());
        entity.setSource(news.getSource());
        if(!entity.getCatalog().getCatid().equals(news.getCatalog().getCatid())){
        	entity.setCatalog(news.getCatalog());
        }
        dao.update(entity);
        this.messageshow("修改成功");
        return "print";
    }
    
    private void messageshow(String msg){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(msg);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, message);
    }
}
