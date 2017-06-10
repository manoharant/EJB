package net.learntechnology.service;

import java.util.List;

import javax.ejb.Local;

import net.learntechnology.persistence.entity.User;

@Local
public interface UserService {
    List<User> getUsers();
}
