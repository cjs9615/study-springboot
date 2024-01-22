package edu.pnu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository memberRepo;

	@Override
	public void insertMember(Member member) {
		member.setEnabled(true);
		member.setRole(Role.ROLE_MEMBER);
		memberRepo.save(member);
	}

	@Override
	public Member findMember(String username) {
		Optional<Member> option = memberRepo.findById(username);
		if (!option.isPresent()) {
			return Member.builder().build();
		}
		Member member = option.get();
		return member;
	}

}
