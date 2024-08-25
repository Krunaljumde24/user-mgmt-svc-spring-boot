/**
 * 
 */
package com.devspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devspace.controller.UserController;
import com.devspace.dao.UserDao;
import com.devspace.model.User;

/**
 * @author kruna
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findUserByFName(String fName) {
		User user = null;
		for (User us : UserController.userList) {
			if (fName.equals(us.getFirstName())) {
				user = us;
			}
		}
		return user;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public String addUser(User obj) {
		return userDao.addUser(obj);
	}
}
