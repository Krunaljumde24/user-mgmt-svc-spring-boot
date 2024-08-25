/**
 * 
 */
package com.devspace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devspace.model.User;
import com.devspace.service.UserService;

/**
 * @author kruna
 *
 */
@RestController
@RequestMapping("/user-svc")
public class UserController {

	public static ArrayList<User> userList = new ArrayList<User>();

//	UserService userService = new UserService();

	@Autowired
	UserService userService;

	@GetMapping(value = "/", produces = "application/json")
	public String index() {
		return "Hello";
	}

	@GetMapping("/getUserList")
	public ArrayList<User> getUser() {
		return userList;
	}

	@GetMapping("/addUser")
	public String user(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName,
			@RequestParam("email") String email, @RequestParam("profession") String prof,
			@RequestParam("gender") String gender, @RequestParam("mobileNumber") Long mNum) {

		User user = new User();
		user.setFirstName(fName);
		user.setLastName(lName);
		user.setEmail(email);
		user.setGender(gender);
		user.setMobileNumber(mNum);
		user.setProfession(prof);

		userList.add(user);

		return "User Added";
	}

	@PostMapping(value = "/addUser", consumes = "application/json", produces = "application/json")
	public String user2(@RequestBody User obj) {
		return userService.addUser(obj);
	}

	@GetMapping(value = "/getUserByFname")
	public User getUserByFname(@RequestParam("firstName") String fName) {
		return userService.findUserByFName(fName);
	}

	@GetMapping(value = "/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
