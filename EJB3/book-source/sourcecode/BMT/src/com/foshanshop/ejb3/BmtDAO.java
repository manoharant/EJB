package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.WebSite;

public interface BmtDAO {

	public void commit(WebSite webSite1, WebSite webSite2);

	public void rollback(WebSite webSite1, WebSite webSite2);


	 public void jndisaveSite(WebSite webSite);

	 public void contextsaveSite(WebSite webSite);
}
