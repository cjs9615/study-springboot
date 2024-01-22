package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberH2Impl implements MemberInterface {

	Connection con;
	
	public MemberH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/mission2", "sa", "abcd");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
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
	
	@Override
	public Map<String, Object> getMembers(){
		Statement st = null;
		ResultSet rs = null;
		
		String query = "select * from member";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			List<MemberVO> list = new ArrayList<>();
			
			while(rs.next()) {
				MemberVO m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build();
				list.add(m);
			}
			
			Map<String, Object> map = new HashMap<>();
			map.put("sql", query);
			map.put("data", list);
			return map;
			
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
		
		return null;
		
	}
	@Override
	public Map<String, Object> getMember(int id) {
		Statement st = null;
		ResultSet rs = null;
		
		String query = "select * from member where id = " + id;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			MemberVO m = null;
			while(rs.next()) {	
				m = MemberVO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build();
			}
			Map<String, Object> map = new HashMap<>();
			map.put("sql", query);
			map.put("data", m);
			return map;
			
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
		return null;
	}
	
	@Override
	public int updateMember(MemberVO membervo){
		int result = 0;
		PreparedStatement psmt = null;
		
		if(membervo.getId() == null) return result;
		if(membervo.getName() == null && membervo.getPass() == null) return result;
		
		try {
			if(membervo.getName() == null) {
				String query = "update member set"
						+ " pass=? "
						+ " where id=?";
						
				psmt = con.prepareStatement(query);
				psmt.setString(1, membervo.getPass());
				psmt.setInt(2, membervo.getId());
			}
			else if(membervo.getPass() == null) {
				String query = "update member set"
						+ " name=? "
						+ " where id=?";
						
				psmt = con.prepareStatement(query);
				psmt.setString(1, membervo.getName());
				psmt.setInt(2, membervo.getId());
			}
			else {
				String query = "update member set"
						+ " pass=?, name=? "
						+ " where id=?";
						
				psmt = con.prepareStatement(query);
				psmt.setString(1, membervo.getPass());
				psmt.setString(2, membervo.getName());
				psmt.setInt(3, membervo.getId());
			}
			
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
	@Override
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
