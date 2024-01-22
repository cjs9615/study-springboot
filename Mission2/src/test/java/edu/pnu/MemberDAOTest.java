package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
public class MemberDAOTest {

	@BeforeEach
	public void print() {
		System.out.println("=".repeat(20));
	}
	
	//@Test
	public void testInsert() {
		MemberDAO dao = new MemberDAO();
		int ret = dao.addMember(MemberVO.builder()
				.pass("1234")
				.name("홍삼동")
				.build());
		
		System.out.println("ret:" + ret);
	}
	
	@Test
	@Order(1)
	public void testSelectAll() {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.getMembers();
		
		for(MemberVO m : list)
			System.out.println(m);
	}
	
	@Test
	@Order(2)
	public void testSelectId() {
		MemberDAO dao = new MemberDAO();
		MemberVO m = dao.getMember(2);
		
		System.out.println(m);
	}
	
	//@Test
	public void testUpdate() {
		MemberDAO dao = new MemberDAO();
		int ret = dao.updateMember(MemberVO.builder()
						.id(1)
						.pass("1234")
						.name("홍길동동")
						.regidate(new Date())
						.build());
		System.out.println("ret:" + ret);
	}
	
	@Test
	public void testRemove() {
		MemberDAO dao = new MemberDAO();
		int ret = dao.removeMember(3);
		System.out.println("ret:" + ret);
	}
	
	
}
