package com.foshanshop.struts.action;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.foshanshop.bean.NewsCatalog;
import com.foshanshop.bean.QueryResult;
import com.foshanshop.dao.CatalogLocalDAO;
import com.foshanshop.utils.EJBFactory;
import com.foshanshop.utils.Page;
import com.foshanshop.utils.Tool;
/**
 * 目录列表分页显示
 * @author lihuoming
 *
 */
public class CatalogAction extends Action{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        int firstResult = Tool.parseInt(request.getParameter("firstResult"));
        if(firstResult<0) firstResult = 0;
        int maxResult = Tool.parseInt(request.getParameter("maxResult"));
        if(maxResult<1 || maxResult>100) maxResult = 5;
        LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
        orderBy.put("catid", "DESC");
        QueryResult result = dao.getResultList(NewsCatalog.class, firstResult, maxResult, orderBy);
        Page page = new Page(firstResult, maxResult);
        page.calculate(result.getRecordtotal());//计算总页数及当前页
        request.setAttribute("dataScroller", page);
        request.setAttribute("result", result);
        return mapping.findForward("List");
    }
}
