package edu.pnu;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberTest {
	
	@Autowired
	private MemberRepository memberRepo;  //
	
	@Test
	@Order(1)
	public void MemberInsertOneBuilder() {
		memberRepo.save(Member.builder()
					.id("id" + 1)
					.password("1234")
					.name("name")
					.role("role")
					.build());
	}
	
	@Test
	@Order(2)
	public void MemberInsertManyBuilder() {
		for(int i = 2; i <= 10; i++) {
			memberRepo.save(Member.builder()
					.id("id" + i)
					.password("1234")
					.name("name" + i)
					.role("role")
					.build());
		}
	}
	
	@Test
	@Order(3)
	public void testGetMember() {
		//Member member = memberRepo.findById("id1");
	}

}
