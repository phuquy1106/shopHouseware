package giadung.webmvc.service.impl;


import java.util.List;

import giadung.webmvc.dao.UserDao;
import giadung.webmvc.dao.impl.UserDaoImpl;
import giadung.webmvc.model.User;
import giadung.webmvc.service.UserService;

public class UserServicesImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	
	public void insert(User user) {
		userDao.insert(user);
	}

	
	public void edit(User newUser) {
		User oldUSer = userDao.get(newUser.getId());
		oldUSer.setName(newUser.getName());
		oldUSer.setEmail(newUser.getEmail());
		oldUSer.setPhone(newUser.getPhone());
		oldUSer.setUsername(newUser.getUsername());
		oldUSer.setPassword(newUser.getPassword());
		oldUSer.setCreated(newUser.getCreated());
		userDao.edit(oldUSer);

	}

	
	public List<User> getAll() {
		return userDao.getAll();
	}

	
	public void delete(int id) {
		userDao.delete(id);
		
	}

	
	public User get(int id) {
		return userDao.get(id);
	}

	
	public User get(String username) {
	
		return userDao.get(username);
	}


	public int editpass(User user) {
		// TODO Auto-generated method stub
		return userDao.editpass(user);
	}


	public void edituser(User user) {
		userDao.edituser(user);
		
	}


	public List<User> getAllRole(String role) {
		return userDao.getAllRole(role);
	}


}