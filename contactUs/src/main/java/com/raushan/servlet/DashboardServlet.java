package com.raushan.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.raushan.dao.RequestDao;
import com.raushan.model.Request;
import com.raushan.util.DatabaseConnection;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            HttpSession session = request.getSession();
	            List<Request> activeUsers = RequestDao.getActiveUsers();
	            List<Request> inactiveUsers = RequestDao.getInActiveUsers();
	            session.setAttribute("activeUsers", activeUsers);
	            session.setAttribute("inactiveUsers", inactiveUsers);
	            response.sendRedirect("dashboard.jsp");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));   
    	Connection connection=null;
        try 
        {
        	DatabaseConnection databaseConnection = new DatabaseConnection();
        	connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT status FROM survey WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String currentStatus = resultSet.getString("status");
                String newStatus = (currentStatus.equals("Active")) ? "Inactive" : "Active";
                preparedStatement = connection.prepareStatement("UPDATE survey SET status=? WHERE id=?");
                preparedStatement.setString(1, newStatus);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
                response.sendRedirect("dashboard");
            }
          } 
          catch (SQLException e) 
          {
            e.printStackTrace();
          }	
	}
}
