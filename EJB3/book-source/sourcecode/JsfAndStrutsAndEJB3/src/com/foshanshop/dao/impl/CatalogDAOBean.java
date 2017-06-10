package com.foshanshop.dao.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.foshanshop.dao.CatalogDAO;
import com.foshanshop.dao.CatalogLocalDAO;
/**
 * Ŀ¼ʵ�������
 *
 */
@Stateless(mappedName="CatalogDAOBean")
@Remote (CatalogDAO.class)
@Local(CatalogLocalDAO.class)
public class CatalogDAOBean extends DaoSupport implements CatalogDAO, CatalogLocalDAO {

}
