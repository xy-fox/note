package com.xf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/votemanger";
	private static String user = "root";
	private static String password = "123456";
	
     public static Connection getconnetion(){
    	 Connection connection = null;
    	 try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 return connection;
     }
     
     public static void close(Connection connection,PreparedStatement pStatement){
    	 try {
			connection.close();
			pStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     public static void closeRs(ResultSet rSet){
    	 try {
 			rSet.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }
}
