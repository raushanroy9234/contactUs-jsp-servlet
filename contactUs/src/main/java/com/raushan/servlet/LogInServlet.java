package com.raushan.servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.raushan.model.*;
import com.raushan.dao.*;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		try
		{
			boolean isValid = UserDao.isUserValid(user);
	        if(isValid) 
	        {
			response.sendRedirect("dashboard");
		    }else{
			response.sendRedirect("login.jsp");
		    }
	      }catch (ClassNotFoundException | SQLException e) 
	      {
			e.printStackTrace();
		  } 
	}
}
