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
 * JSF��� ������/ɾ/����
 * @author lihuoming
 *
 */
public class NewsAction extends Page{
	/** ����/��� **/
	private News news;
    /** Ŀ¼��ѡ��� **/
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
	 * ��ʼ��������ӽ����Ŀ¼�ֶ�
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
	 * ��ȡĿ¼������
	 * @return
	 */
	public int getSelectItemsSize() {
    	if(this.selectItems==null) this.getSelectItems();
    	return this.selectItems.size();
	}
    /**
     * �������
     */
    public String add() {
    	CatalogLocalDAO catdao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        this.news.setCreatedate(new Date());
        if(this.news.getCatalog().getCatid()!=null && this.news.getCatalog().getCatid()>0){//���Ŀ¼�Ѿ�����
            NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
            dao.save(news);//��������
        }else{
        	catdao.save(this.news.getCatalog());//����Ŀ¼ʱ��������������
        }
        this.messageshow("����ɹ�");
        return "print";
    }
    
    /**
     * ɾ������
     */
    public String delete() {
        NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO"); 
        dao.delete(News.class, this.id);
        this.messageshow("ɾ���ɹ�");
        return "print";
    }
    /**
     * �޸����Ž���
     */
    public String editUI(){
    	NewsLocalDAO newsdao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
    	this.news = newsdao.find(News.class, this.id);
    	return "edit";
    }
    /**
     * �޸�����
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
        this.messageshow("�޸ĳɹ�");
        return "print";
    }
    
    private void messageshow(String msg){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(msg);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, message);
    }
}
