package edu.pnu;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class QueryMethodTest1 {
	
	@Autowired
	BoardRepository boardRepo;

	//@Test
	@Order(1)
	public void InsertBoard() {
		Random rd = new Random();
		for(int i = 1; i <= 100; i++) {
			boardRepo.save(Board.builder()
					.title("title" + i)
					.content("content" + i)
					.writer("writer" + i)
					.cnt(rd.nextLong(0, 101))
					.build());
		}
	}
	
	//@Test
	@Order(2)
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		
		for(Board board : boardList)
			System.out.println(board.toString());
	}
	
	@Test
	public void testFindByTitleContainingAndGreaterThan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
		
		for(Board board : boardList)
			System.out.println(board.toString());
	}
	
	
	
}
