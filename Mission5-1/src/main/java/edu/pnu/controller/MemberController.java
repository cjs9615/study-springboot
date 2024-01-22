package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member")	
	public List<Member> getMembers() {
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public void addMember(Member member) {
		memberService.addMember(member);
	}
}
