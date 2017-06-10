package com.foshanshop.jsf;

import java.util.List;
import java.util.LinkedHashMap;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.foshanshop.bean.NewsCatalog;
import com.foshanshop.bean.QueryResult;
import com.foshanshop.dao.CatalogLocalDAO;
import com.foshanshop.utils.EJBFactory;
import com.foshanshop.utils.Page;
/**
 * 目录分页
 * @author lihuoming
 *
 */
public class CatalogList extends Page{
	private DataModel model;
	/**
	 * 初始化目录列表界面的dataTable组件
	 * @return
	 */
    public DataModel getCatalogs() {
        if(model == null) {
            model = new ListDataModel();
            model.setWrappedData(this.execute());
        }        
        return model; 
    }
	/**
	 * 分页显示
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<NewsCatalog> execute() {
		CatalogLocalDAO dao = (CatalogLocalDAO)EJBFactory.lookup("ejb/CatalogLocalDAO");
        if(this.getFirstResult()<0) this.setFirstResult(0);
        if(this.getMaxResult()<1 || this.getMaxResult()>100) this.setMaxResult(5);
        LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
        orderBy.put("catid", "DESC");
        QueryResult result = dao.getResultList(NewsCatalog.class, this.getFirstResult(), this.getMaxResult(), orderBy);
        this.calculate(result.getRecordtotal());//计算总页数及当前页
		return (List<NewsCatalog>)result.getResultset();
	}
}
