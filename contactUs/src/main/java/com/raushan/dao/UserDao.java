package com.raushan.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.raushan.model.User;
import com.raushan.util.*;

public class UserDao {
	 
	public static boolean isUserValid(User user) throws ClassNotFoundException, SQLException {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("Select username from login where username = ? and password = ?");
		prepareStatement.setString(1,user.getUsername());
		prepareStatement.setString(2,user.getPassword());
		ResultSet resultSet = prepareStatement.executeQuery();
		boolean valid = resultSet.next();
		return valid;
	}
}
