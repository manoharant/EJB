package net.learntechnology.persistence.dao;

import javax.persistence.EntityManager;

public interface DAO {
    void setEm(EntityManager em);
}
