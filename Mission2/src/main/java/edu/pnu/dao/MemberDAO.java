package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDAO {

	Connection con;
	
	public MemberDAO() {
		try {
			Class.forName("org.h2.Driver");
			
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/mission2", "sa", "abcd");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public int addMember(MemberVO membervo) {
		int result = 0;
		PreparedStatement psmt = null;
		
		try {
			String query = "insert into member ( "
					+ " pass,name) "
					+ " values ( ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, membervo.getPass());
			psmt.setString(2, membervo.getName());
			
			result = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public List<MemberVO> getMembers(){
		List<MemberVO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		
		String query = "select * from member";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				MemberVO m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build();
				list.add(m);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return list;
		
	}
	public MemberVO getMember(int id) {
		Statement st = null;
		ResultSet rs = null;
		MemberVO m = null;
		
		String query = "select * from member where id = " + id;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return m;
	}
	
	public int updateMember(MemberVO membervo){
		int result = 0;
		PreparedStatement psmt = null;
		
		try {
			String query = "update member set"
					+ " pass=?, name=? "
					+ " where id=?";
					
			psmt = con.prepareStatement(query);
			psmt.setString(1, membervo.getPass());
			psmt.setString(2, membervo.getName());
			psmt.setInt(3, membervo.getId());
			
			result = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int removeMember(int id) {
		int result = 0;
		PreparedStatement psmt = null;
		
		try {
			String query = "delete from member where id=?";
			
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			result = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}
}
