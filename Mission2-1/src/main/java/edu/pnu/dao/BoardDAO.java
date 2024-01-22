package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.BoardVO;

public class BoardDAO {

	Connection con;
	
	public BoardDAO() {
		try {
			Class.forName("org.h2.Driver");
			
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/mission2", "sa", "abcd");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int addBoard(BoardVO boardVO) {
		int result = 0;
		PreparedStatement psmt = null;
		
		try {
			String query = "insert into board ( "
						+ " title,writer,content,cnt) "
						+ " values( ?,?,?,? )";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, boardVO.getTitle());
			psmt.setString(2, boardVO.getWriter());
			psmt.setString(3, boardVO.getContent());
			psmt.setInt(4, boardVO.getCnt());
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
	
	public List<BoardVO> getBoards() {
		List<BoardVO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		
		String query = "select * from board";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				BoardVO b = BoardVO.builder()
								.seq(rs.getInt("seq"))
								.title(rs.getString("title"))
								.writer(rs.getString("writer"))
								.content(rs.getString("content"))
								.createDate(rs.getDate("createDate"))
								.cnt(rs.getInt("cnt"))
								.build();
				list.add(b);
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
	
	public BoardVO getBoard(int seq) {
		BoardVO b = null;
		Statement st = null;
		ResultSet rs = null;
		
		String query = "select * from board where seq=" + seq;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				b = BoardVO.builder()
						.seq(rs.getInt("seq"))
						.title(rs.getString("title"))
						.writer(rs.getString("writer"))
						.content(rs.getString("content"))
						.createDate(rs.getDate("createDate"))
						.cnt(rs.getInt("cnt"))
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
		
		return b;
	}
	
	public int updateBoard(BoardVO boardVO) {
		int result = 0;
		PreparedStatement psmt = null;
		
		try {
			String query = "update board set"
						+ " title=?, writer=?, content=? "
						+ " where seq=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, boardVO.getTitle());
			psmt.setString(2, boardVO.getWriter());
			psmt.setString(3, boardVO.getContent());
			psmt.setInt(4, boardVO.getSeq());
			
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
	
	public int removeBoard(int seq) {
		int result = 0;
		PreparedStatement psmt = null;
		
		try {
			String query = "delete from board where seq=?";
			
			psmt = con.prepareStatement(query);
			psmt.setInt(1, seq);
			
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
