package edu.pnu.service;

import edu.pnu.domain.Member;

public interface MemberService {
	
	void insertMember(Member member);
	
	Member findMember(String username); 

}
