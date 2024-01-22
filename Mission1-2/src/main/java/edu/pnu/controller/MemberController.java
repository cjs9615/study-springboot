package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

public class MemberController {

	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
}
