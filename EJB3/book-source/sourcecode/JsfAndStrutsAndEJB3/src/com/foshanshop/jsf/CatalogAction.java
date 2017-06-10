package com.foshanshop.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.foshanshop.bean.NewsCatalog;
import com.foshanshop.dao.CatalogLocalDAO;
import com.foshanshop.utils.EJBFactory;
/**
 * JSF��� Ŀ¼��/ɾ/����
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
     * ���Ŀ¼
     */
    public String add() {
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        dao.save(this.catalog);
        this.messageshow("����ɹ�");
        return "print";
    }
    /**
     * �޸�Ŀ¼����
     */
    public String editUI() {
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");       
        this.catalog = dao.find(NewsCatalog.class, this.id);        
        return "edit";
    }
    /**
     * �޸�Ŀ¼
     */
    public String edit() {
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        dao.update(this.catalog);
        this.messageshow("�޸ĳɹ�");
        return "print";
    }
    /**
     * ɾ��Ŀ¼
     */
    public String delete() {
    	CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO"); 
        dao.delete(NewsCatalog.class, this.id);
        this.messageshow("ɾ���ɹ�");
        return "print";
    }
    
    private void messageshow(String msg){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(msg);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, message);
    }
}
