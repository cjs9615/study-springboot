package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class TestMember {

	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void testInsert() {
		for(int i = 1; i <= 7; i++) {
			memberRepo.save(Member.builder()
							.name("name" + i)
							.pass("pass" + i)
							.regidate(new Date())
							.build());
		}
	}
}
