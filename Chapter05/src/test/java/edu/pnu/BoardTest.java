package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
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
public class BoardTest {

	@Autowired
	private BoardRepository boardRepo;  //
	
	@DisplayName("보드 한 개 입력 테스트")
	@Test
	@Order(1)
	public void BoardInsertOne() {
		Board board = new Board();
		board.setTitle("title");
		board.setWriter("writer");
		board.setContent("content");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRepo.save(board);
	}
	
	@DisplayName("보드(builder) 한 개 입력 테스트")
	@Test
	@Order(2)
	public void BoardInsertOneBuilder() {
		boardRepo.save(Board.builder()
					.title("title")
					.writer("writer")
					.content("content")
					.build());
	}
	
	@DisplayName("보드 여러 개 입력 테스트")
	@Test
	@Order(3)
	public void BoardInsertMany() {
		for(int i = 1; i <= 10; i++ ) {
			Board board = new Board();
			board.setTitle("title" + i);
			board.setWriter("writer" + (i%3 + 1));
			board.setContent("content" + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			boardRepo.save(board);
		}
	}
	
	@DisplayName("보드(builder) 여러 개 입력 테스트")
	@Test
	@Order(4)
	public void BoardInsertManyBuilder() {
		for(int i = 1; i <= 10; i++) {
			boardRepo.save(Board.builder()
					.title("title" + i)
					.writer("writer" + (i%3 + 1))
					.content("content" + i)
					.build());
		}
	}
	
	@Test
	@Order(5)
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}
	
	@Test
	@Order(6)
	public void testUpdateBoard() {
		System.out.println("=== 1번 게시글 조회 ===");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("=== 1번 게시글 제목 수정 ===");
		board.setTitle("제목을 수정했습니다.");
		boardRepo.save(board);
	}
	
	@Test
	@Order(7)
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
	
}
