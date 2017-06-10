package com.foshanshop.dao.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import com.foshanshop.dao.NewsDAO;
import com.foshanshop.dao.NewsLocalDAO;
/**
 * ����ʵ�������
 * @author lihuoming
 *
 */
@Stateless(mappedName="NewsDAOBean")
@Remote (NewsDAO.class)
@Local(NewsLocalDAO.class)
public class NewsDAOBean extends DaoSupport implements NewsDAO, NewsLocalDAO {
}
