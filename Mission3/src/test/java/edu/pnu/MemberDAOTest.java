package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAOH2Impl;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberDAOTest {
	
	// Test Order 순서대로 실행 될 떄 메소드만 순서대로 실행되는게 아니라 클래스 전체 다시 실행

	MemberInterface dao = new MemberDaoListImpl();
	
//	@BeforeEach
//	public void print() {
//		System.out.println("=".repeat(20));
//	}
	
//	@Test
//	@Order(1)
	@BeforeEach
	public void testInsert() {
		int ret = dao.addMember(MemberVO.builder()
				.pass("1234")
				.name("홍삼동")
				.build());
			
		System.out.println("ret:" + ret);
		
		List<MemberVO> list = dao.getMembers();
		
		for(MemberVO m : list)
			System.out.println(m);
	}
	
	@Test
	@Order(2)
	public void testSelectAll() {
//		dao = new MemberDAOH2Impl();
		List<MemberVO> list = dao.getMembers();
		
		for(MemberVO m : list)
			System.out.println(m);
	}
	
	@Test
	@Order(3)
	public void testSelectId() {
//		dao = new MemberDAOH2Impl();
		MemberVO m = dao.getMember(5);
		
		System.out.println(m);
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
//		dao = new MemberDAOH2Impl();
		int ret = dao.updateMember(MemberVO.builder()
						.id(5)
						.pass("12341234")
						.regidate(new Date())
						.build());
		System.out.println("ret:" + ret);
		
		List<MemberVO> list = dao.getMembers();
		
		for(MemberVO m : list)
			System.out.println(m);
	}
	
	@Test
	@Order(5)
	public void testRemove() {
//		dao = new MemberDAOH2Impl();
		int ret = dao.removeMember(5);
		System.out.println("ret:" + ret);
		
		List<MemberVO> list = dao.getMembers();
		
		for(MemberVO m : list)
			System.out.println(m);
	}
	
	
}
