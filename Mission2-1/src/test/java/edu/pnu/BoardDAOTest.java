package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.pnu.dao.BoardDAO;
import edu.pnu.domain.BoardVO;

public class BoardDAOTest {

	//@Test
	public void testInsert() {
		BoardDAO dao = new BoardDAO();
		int ret = dao.addBoard(BoardVO.builder()
				.title("title3")
				.writer("writer3")
				.content("content3")
				.cnt(0)
				.build());
		
		System.out.println("ret:" + ret);
	}
	
	//@Test
	public void testSelectAll() {
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.getBoards();
		
		for(BoardVO b : list)
			System.out.println(b);
	}
	
	//@Test
	public void testSelectId() {
		BoardDAO dao = new BoardDAO();
		BoardVO b = dao.getBoard(2);
		
		System.out.println(b);
	}
	
	//@Test
	public void testUpdate() {
		BoardDAO dao = new BoardDAO();
		int ret = dao.updateBoard(BoardVO.builder()
				.seq(2)
				.title("title22")
				.writer("writer22")
				.content("content22")
				.createDate(new Date())
				.cnt(0)
				.build()
				);
		
		System.out.println(ret);
	}
	
	@Test
	public void testRemoveId() {
		BoardDAO dao = new BoardDAO();
		int ret = dao.removeBoard(3);
		
		System.out.println(ret);
	}
}
