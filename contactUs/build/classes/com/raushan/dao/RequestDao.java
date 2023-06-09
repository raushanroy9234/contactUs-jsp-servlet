package com.raushan.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.raushan.model.Request;
import com.raushan.util.DatabaseConnection;

public class RequestDao {
	static Connection connection;
	public static List<Request> getActiveUsers() throws SQLException {
	    List<Request> requestList = new ArrayList<>();
		DatabaseConnection databaseConnection = new DatabaseConnection();
		connection = databaseConnection.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("Select * from survey");
		ResultSet allRequests = prepareStatement.executeQuery();
		while (allRequests.next()) {
			Request request = new Request();
			request.setId(allRequests.getString(1));
			request.setName(allRequests.getString(2));
			request.setEmail(allRequests.getString(3));
			request.setMessage(allRequests.getString(4));
			request.setStatus(allRequests.getString(5));
			requestList.add(request);
		}
		List<Request> activeUsers = new ArrayList<>();
	    for (Request request : requestList) {
	        if (request.getStatus().equals("Active")) {
	            activeUsers.add(request);
	        }
	    }
	    return activeUsers;
	}
	
	public static List<Request> getInActiveUsers() throws SQLException {
	    List<Request> requestList = new ArrayList<>();
		DatabaseConnection databaseConnection = new DatabaseConnection();
		connection = databaseConnection.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("Select * from survey");
		ResultSet allRequests = prepareStatement.executeQuery();
		while (allRequests.next()) {
			Request request = new Request();
			request.setId(allRequests.getString(1));
			request.setName(allRequests.getString(2));
			request.setEmail(allRequests.getString(3));
			request.setMessage(allRequests.getString(4));
			request.setStatus(allRequests.getString(5));
			requestList.add(request);
		}
		List<Request> inactiveUsers = new ArrayList<>();
	    for (Request request : requestList) {
	        if (request.getStatus().equals("Inactive")) {
	            inactiveUsers.add(request);
	        }
	    }
	    return inactiveUsers;
	}
}
