package blogspot.sezera.exampleproject.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import blogspot.sezera.exampleproject.dao.GenericDaoImpl;
import blogspot.sezera.exampleproject.domain.User;
import blogspot.sezera.exampleproject.service.UserService;

public class UserServiceImpl implements UserService {

	private SessionFactory m_sessionFactory;
	private GenericDaoImpl<User, Long> userDao;

	public UserServiceImpl(SessionFactory sessionFactory) {
		m_sessionFactory = sessionFactory;
		userDao = new GenericDaoImpl<User, Long>(m_sessionFactory) {
		};
	}

	public void createUser(String username, String password) {
		User user = null;
		if (username != null) {
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userDao.makePersistent(user);
		}
	}

	public List UserList() {
		return null;
	}
}