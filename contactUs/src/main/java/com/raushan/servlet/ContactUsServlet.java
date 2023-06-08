package com.raushan.servlet;
import com.raushan.model.*;
import com.raushan.util.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("contactus.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		Request request = new Request();
		request.setName(name);
		request.setEmail(email);
		request.setMessage(message);
		try{
			DatabaseConnection databaseConnection = new DatabaseConnection();
			Connection connection = databaseConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("Insert into survey (name, email, message,status) values (?,?,?,?)");
			prepareStatement.setString(1, request.getName());
			prepareStatement.setString(2, request.getEmail());
			prepareStatement.setString(3, request.getMessage());
			prepareStatement.setString(4, "Active");
			prepareStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
		res.sendRedirect("contactus.jsp");
	}
}
