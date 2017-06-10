package com.foshanshop.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.foshanshop.bean.NewsCatalog;
import com.foshanshop.dao.CatalogLocalDAO;
import com.foshanshop.utils.EJBFactory;
/**
 * JSF框架 目录添/删/改类
 * @author lihuoming
 *
 */
public class CatalogAction {
    private NewsCatalog catalog;
    private int id;
    
	public CatalogAction() {
		this.catalog = new NewsCatalog();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
    public NewsCatalog getCatalog() {
		return catalog;
	}
	public void setCatalog(NewsCatalog catalog) {
		this.catalog = catalog;
	}
	/**
     * 添加目录
     */
    public String add() {
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        dao.save(this.catalog);
        this.messageshow("保存成功");
        return "print";
    }
    /**
     * 修改目录界面
     */
    public String editUI() {
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");       
        this.catalog = dao.find(NewsCatalog.class, this.id);        
        return "edit";
    }
    /**
     * 修改目录
     */
    public String edit() {
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        dao.update(this.catalog);
        this.messageshow("修改成功");
        return "print";
    }
    /**
     * 删除目录
     */
    public String delete() {
    	CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO"); 
        dao.delete(NewsCatalog.class, this.id);
        this.messageshow("删除成功");
        return "print";
    }
    
    private void messageshow(String msg){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(msg);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, message);
    }
}
