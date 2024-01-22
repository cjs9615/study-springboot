package edu.pnu.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
//	List<Board> findByTitle(String searchKeyword);
//	List<Board> findByTitleContaining(String searchKeyword);
//	//List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
//	List<Board> findByTitleContainingAndCntGreaterThan(String title, Long cnt);
//	List<Board> findByContentContaining(String searchKeyword);
//	List<Board> findByTitleContainingOrContentContaining(String title, String content);
//	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
//	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
//	
//	//@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	//List<Board> queryAnnotationTest1(String seqrchKeyword);
//	
//	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
//	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Object[]> queyrAnnotationTest2(String searchKeyword);
//	
//	//database에 직접 접근 하니까 create_date로 해야함
//	@Query(value="select seq, title, writer, create_Date from board where title like '%'||?1||'%' order by seq desc", nativeQuery=true)
//	List<Object[]> queryAnnotationTest3(String searchKeyword);
}
