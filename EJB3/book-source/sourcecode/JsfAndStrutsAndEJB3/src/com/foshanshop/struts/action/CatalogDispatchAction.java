package com.foshanshop.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.foshanshop.bean.NewsCatalog;
import com.foshanshop.dao.CatalogLocalDAO;
import com.foshanshop.struts.formbean.NewsFormBean;
import com.foshanshop.utils.EJBFactory;
/**
 * 目录处理
 * @author lihuoming
 *
 */
public class CatalogDispatchAction extends DispatchAction{
    /**
     * 添加目录界面
     */
    public ActionForward addUI(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("addOreditUI");
    }
    /**
     * 添加目录
     */
    public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsFormBean newsform = (NewsFormBean) form;
        NewsCatalog cat = new NewsCatalog(newsform.getCatalogname());
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        dao.save(cat);
        request.setAttribute("outmessage", "保存成功");
        return mapping.findForward("print");
    }
    /**
     * 修改目录界面
     */
    public ActionForward editUI(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");       
        NewsCatalog cat = dao.find(NewsCatalog.class, new Integer(request.getParameter("id")));
        NewsFormBean newsform = (NewsFormBean) form;
        newsform.setCatalogname(cat.getName());
        newsform.setCatid(cat.getCatid());
        request.setAttribute("method", "edit");        
        return mapping.findForward("addOreditUI");
    }
    /**
     * 修改目录
     */
    public ActionForward edit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsFormBean newsform = (NewsFormBean) form; 
        NewsCatalog cat = new NewsCatalog(newsform.getCatid());       
        cat.setName(newsform.getCatalogname());
        CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        dao.update(cat);
        request.setAttribute("outmessage", "修改成功");
        return mapping.findForward("print");
    }
    /**
     * 删除目录
     */
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO"); 
        dao.delete(NewsCatalog.class, new Integer(request.getParameter("id")));
        request.setAttribute("outmessage", "删除成功");
        return mapping.findForward("print");
    }
}
