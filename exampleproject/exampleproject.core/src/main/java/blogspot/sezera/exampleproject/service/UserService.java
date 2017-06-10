package blogspot.sezera.exampleproject.service;

import java.util.List;

public interface UserService {

	void createUser(String username, String password);

	List UserList();

}