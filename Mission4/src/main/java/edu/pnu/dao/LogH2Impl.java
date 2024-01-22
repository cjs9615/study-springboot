package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LogH2Impl {
	Connection con;
	
	public LogH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/mission2", "sa", "abcd");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void addLog(String method, String sqlquery, Object o) {
		PreparedStatement psmt = null;
		
		try {
			String query = "insert into dblog ( "
					+ " method,sqlstring,success) "
					+ " values ( ?, ?, ? )";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, method);
			psmt.setString(2, sqlquery);
			if(o == null) psmt.setBoolean(3, false);
			else          psmt.setBoolean(3, true);
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
