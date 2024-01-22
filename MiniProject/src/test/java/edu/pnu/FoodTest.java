package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.pnu.domain.Member;
import edu.pnu.domain.MemberFood;
import edu.pnu.domain.Role;
import edu.pnu.persistence.FoodRepository;
import edu.pnu.persistence.MemberFoodRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class FoodTest {
	@Autowired
	private FoodRepository foodRepo;
	@Autowired
	private MemberRepository memRepo;
	@Autowired
	private MemberFoodRepository memfoodRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//@Test
	public void testGet() {
		memRepo.save(Member.builder()
				.username("member")
				.password(encoder.encode("abcd"))
				.role(Role.ROLE_MEMBER)
				.enabled(true).build());
	}
	
	@Test
	public void testInsert() {
		memfoodRepo.save(MemberFood.builder()
				.id(1L)
				.member(memRepo.findById("member").get())
				.food(foodRepo.findById(1L).get())
				.build());
	}
}
