package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	public List<Member> getMembers() {
		return memberRepo.findAll();
	}
	
	public Member getMember(Integer id) {
		if(memberRepo.findById(id).isEmpty()) return null;
		return memberRepo.findById(id).get();
	}
	
	public void addMember(Member member) {
		if(member.getPass() == null || member.getName() == null) return;
		memberRepo.save(Member.builder()
						.name(member.getName())
						.pass(member.getPass())
						.regidate(new Date())
						.build());
	}
	
	public void updateMember(Member member) {
		if(member.getId() == null || memberRepo.findById(member.getId()).isEmpty()) return;
		Member m = memberRepo.findById(member.getId()).get();
	}
}
