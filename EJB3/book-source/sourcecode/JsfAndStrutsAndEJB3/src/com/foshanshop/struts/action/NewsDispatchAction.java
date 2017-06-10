package com.foshanshop.struts.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.foshanshop.bean.News;
import com.foshanshop.bean.NewsCatalog;
import com.foshanshop.dao.CatalogLocalDAO;
import com.foshanshop.dao.NewsLocalDAO;
import com.foshanshop.struts.formbean.NewsFormBean;
import com.foshanshop.utils.EJBFactory;
/**
 * ���Ŵ���
 * @author lihuoming
 *
 */
@SuppressWarnings("unchecked")
public class NewsDispatchAction extends DispatchAction{
    /**
     * �鿴����
     */
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {        
        NewsLocalDAO newsdao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
        News news = newsdao.find(News.class, new Integer(request.getParameter("id")));
        request.setAttribute("entry", news);        
        return mapping.findForward("view");
    }
    /**
     * ������Ž���
     */    
	public ActionForward addUI(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {   
    	CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
    	LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
        orderBy.put("catid", "DESC");
    	List catalog = dao.getResultList(NewsCatalog.class, -1, -1, orderBy).getResultset();
    	request.setAttribute("catalog", catalog);
        return mapping.findForward("addOreditUI");
    }
    /**
     * �������
     */
    public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {        
    	CatalogLocalDAO catdao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        NewsFormBean newsform = (NewsFormBean) form;
        News news = new News(newsform.getTitle());
        news.setContent(newsform.getContent());
        news.setCreatedate(new Date());
        news.setSource(newsform.getSource());
        if(newsform.getCatid()!=null && newsform.getCatid()>0){
        	NewsCatalog cat = new NewsCatalog(newsform.getCatid());
        	cat.addNews(news);
        	news.setCatalog(cat);
            NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
            dao.save(news);//��������
        }else{
        	NewsCatalog cat = new NewsCatalog(newsform.getCatalogname());
        	cat.addNews(news);
        	catdao.save(cat);//����Ŀ¼ʱ��������������
        }
        request.setAttribute("outmessage", "����ɹ�");
        return mapping.findForward("print");
    }
    /**
     * �޸����Ž���
     */
    public ActionForward editUI(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {        
        NewsLocalDAO newsdao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
        CatalogLocalDAO catdao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        News news = newsdao.find(News.class, new Integer(request.getParameter("id")));
        NewsFormBean newsform = (NewsFormBean) form;
        newsform.setContent(news.getContent());
        newsform.setTitle(news.getTitle());
        newsform.setSource(news.getSource());
        newsform.setNewsid(news.getNewsid());
        newsform.setCatid(news.getCatalog().getCatid());
        LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
        orderBy.put("catid", "DESC");
    	List catalog = catdao.getResultList(NewsCatalog.class, -1, -1, orderBy).getResultset();
    	request.setAttribute("catalog", catalog);
        request.setAttribute("method", "edit");        
        return mapping.findForward("addOreditUI");
    }
    /**
     * �޸�����
     */
    public ActionForward edit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsFormBean newsform = (NewsFormBean) form;
        NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");       
        News news = dao.find(News.class, newsform.getNewsid());       
        news.setContent(newsform.getContent());
        news.setTitle(newsform.getTitle());
        news.setSource(newsform.getSource());
        if(!news.getCatalog().getCatid().equals(newsform.getCatid())){
        	NewsCatalog cat = new NewsCatalog(newsform.getCatid());
        	cat.addNews(news);
        	news.setCatalog(cat);
        }
        dao.update(news);
        request.setAttribute("outmessage", "�޸ĳɹ�");
        return mapping.findForward("print");
    }
    /**
     * ɾ������
     */
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO"); 
        dao.delete(News.class, new Integer(request.getParameter("id")));
        request.setAttribute("outmessage", "ɾ���ɹ�");
        return mapping.findForward("print");
    }
}
