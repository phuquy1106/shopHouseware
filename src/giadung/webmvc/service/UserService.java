package giadung.webmvc.service;

import java.util.List;

import giadung.webmvc.model.User;
public interface UserService {
	
void insert(User user);
	
	void edit(User user);
	
	void delete(int id);
	
	User get(int id);
	
	User get(String username);

	List<User> getAll();

	int editpass(User user);

	void edituser(User user);

	List<User> getAllRole(String role);

}

