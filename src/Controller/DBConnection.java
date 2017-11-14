package Controller;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	Connection conn = null;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
	String user = "root";
	String pwd = "admin";

	private static DBConnection instance = null;

	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	} 

	public Connection getConnection() throws SQLException {
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = (Connection)DriverManager.getConnection(url, user, pwd);
				if (conn != null) {
					System.out.println("Connected");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = null;
	}
}

