package blogspot.sezera.exampleproject.controller;

import blogspot.sezera.exampleproject.service.UserService;

public class UserController {

	private UserService service;
	private String username;
	private String password;
	
	public UserController(){
		
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	public void createUser(){
		service.createUser(username, password);
	}
	public UserService getService() {
		return service;
	}
}