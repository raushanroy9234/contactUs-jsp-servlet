package com.raushan.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	String jdbcUrl = "jdbc:postgresql://localhost:6480/contact_us";
    String username = "postgres";
    String password = "1Admin@#";
    Connection connection=null;
    
    public  Connection getConnection(){
      try {
         Class.forName("org.postgresql.Driver");
         connection = DriverManager.getConnection(jdbcUrl, username, password);
         }
      catch(Exception e) {
    	e.printStackTrace();
        }
        return connection;
    }
}
