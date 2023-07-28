package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class DBConnectionPool {
	private String id;
	private String pw;
	private String url;
	
	protected static Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DBConnectionPool() {
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/moviedb";
		
		try {
			//db연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(conn==null) {
				conn = DriverManager.getConnection(url, id, pw);
				System.out.println("연결 성공");
			}
		}  catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
