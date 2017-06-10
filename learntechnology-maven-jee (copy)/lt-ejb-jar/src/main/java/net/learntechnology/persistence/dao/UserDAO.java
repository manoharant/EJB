package net.learntechnology.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import net.learntechnology.persistence.entity.User;

@Local
public interface UserDAO extends DAO {
    public List<User> getUsers();
    public User saveUser(User user);
}
