package edu.pnu;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;
	
	//@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("title1");
		
		for (Board board : boardList)
			System.out.println(board);
	}
	
	//@Test
	public void testQueryAnnotationTest2() {
		List<Object[]> boardList = boardRepo.queyrAnnotationTest2("title1");
		
		for (Object[] row : boardList)
			System.out.println(Arrays.toString(row));
	}
	
	@Test
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("title1");
		
		for (Object[] row : boardList)
			System.out.println(Arrays.toString(row));
	}
}
