package com.foshanshop.jsf;

import java.util.List;
import java.util.LinkedHashMap;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.foshanshop.bean.News;
import com.foshanshop.bean.QueryResult;
import com.foshanshop.dao.NewsLocalDAO;
import com.foshanshop.utils.EJBFactory;
import com.foshanshop.utils.Page;
/**
 * 新闻分页
 * @author lihuoming
 *
 */
public class NewsList extends Page{
	private DataModel model;
	/**
	 * 初始化新闻列表界面的dataTable组件
	 * @return
	 */
    public DataModel getNewslist() {
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
	public List<News> execute() {
		NewsLocalDAO dao = (NewsLocalDAO)EJBFactory.lookup("ejb/NewsLocalDAO");
        if(this.getFirstResult()<0) this.setFirstResult(0);
        if(this.getMaxResult()<1 || this.getMaxResult()>100) this.setMaxResult(5);
        LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
        orderBy.put("newsid", "DESC");
        QueryResult result = dao.getResultList(News.class, this.getFirstResult(), this.getMaxResult(), orderBy);
        this.calculate(result.getRecordtotal());//计算总页数及当前页
		return (List<News>)result.getResultset();
	}
}
