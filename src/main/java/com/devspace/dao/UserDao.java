/**
 * 
 */
package com.devspace.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.devspace.mapper.UserMapper;
import com.devspace.model.User;

/**
 * @author kruna
 *
 */
@Component
public class UserDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public String addUser(User user) {
		Integer rowcount = 0;
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("fName", user.getFirstName());
		map.addValue("lName", user.getLastName());
		map.addValue("email", user.getEmail());
		map.addValue("prof", user.getProfession());
		map.addValue("gender", user.getGender());
		map.addValue("mobile", user.getMobileNumber());
		try {
			rowcount = jdbcTemplate.update(
					"INSERT INTO user.user_details (first_name, last_name, email_id, profession, gender, mobile_number)\r\n"
							+ "VALUES (:fName, :lName, :email, :prof, :gender, :mobile)",
					map);
		} catch (Exception exception) {
			throw exception;
		}
		if (rowcount > 0) {
			return "User Added";
		} else {
			return "User Not Added";
		}
	}

	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			userList = jdbcTemplate.query("SELECT * FROM user.user_details", new UserMapper());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return userList;
	}
}
