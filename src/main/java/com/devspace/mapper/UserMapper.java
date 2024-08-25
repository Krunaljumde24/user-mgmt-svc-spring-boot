/**
 * 
 */
package com.devspace.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devspace.model.User;

/**
 * @author kruna
 *
 */
@Component
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setEmail(rs.getString(4));
		user.setProfession(rs.getString(5));
		user.setGender(rs.getString(6));
		user.setMobileNumber(rs.getLong(7));
		return user;
	}

}
