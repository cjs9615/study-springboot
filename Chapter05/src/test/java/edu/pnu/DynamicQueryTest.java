package edu.pnu;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.DynamicBoardRepository;

@SpringBootTest
public class DynamicQueryTest {
	@Autowired
	private DynamicBoardRepository boardRepo;
	
	//@Test
	public void testInsertBoard() {
		Random rd = new Random();
		for(int i = 1; i <= 100; i++) {
			Board b = Board.builder()
						.title("title" + i)
						.writer("writer" + i)
						.content("content" + i)
						.cnt(rd.nextLong(0, 101))
						.build();
			boardRepo.save(b);
		}
	}
	
	@Test
	public void testDynamicQuery() {
		String searchCondition = "TITLE";
		String searchKeyword = "title";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if(searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	@Test
	public void testDynamicQuery1() {
		String searchCondition = "TITLE";
		String searchKeyword = "title1";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	@Test
	public void testDynamicQuery2() {
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		builder.and(qboard.cnt.gt(50L));  //gt = graterthan
		
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
