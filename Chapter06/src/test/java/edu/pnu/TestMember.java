package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class TestMember {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testInsert() {
		for (int i = 1; i <= 5; i++) {
			Board board = new Board();
			board.setWriter("둘리");
			board.setTitle("둘리tittle" +  i);
			board.setContent("둘리content" + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		
		for (int i = 1; i <= 5; i++) {
			Board board = new Board();
			board.setWriter("도우너");
			board.setTitle("도우너tittle" +  i);
			board.setContent("도우너content" + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}
}
