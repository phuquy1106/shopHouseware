package giadung.webmvc.dao;

import java.util.List;

import giadung.webmvc.model.User;

public interface UserDao {
	
	void insert(User user);

	void edit(User user);
	
	void delete(int id);

	User get(int name);

	User get(String userName);
	
	List<User> getAll();

	int editpass(User user);

	void edituser(User user);

	List<User> getAllRole(String role);
}
