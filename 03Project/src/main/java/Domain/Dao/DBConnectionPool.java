package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DBConnectionPool {
	protected static String id = "root";
	protected static String pw = "1234";
	protected static String url;
	
	public static Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public static void createConnectionPool() {
		url = "jdbc:mysql://localhost:3306/moviedb";
		
		try {
			//db연결 
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, id, pw);
				System.out.println("연결 성공");
			}
		}  catch(Exception e) {
			e.printStackTrace();
		}
	}
		DBConnectionPool(){
	}
	
}
