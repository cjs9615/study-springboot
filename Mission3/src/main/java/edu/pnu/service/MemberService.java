package edu.pnu.service;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDAOH2Impl;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	private MemberInterface memberInterface;

	public MemberService(Environment environment) {
		String type = environment.getProperty("service.type");
		
		if(type != null && type.equals("h2")) {
			System.out.println("h2");
			memberInterface = new MemberDAOH2Impl();
		}
		else {
			System.out.println("list");
			memberInterface = new MemberDaoListImpl();
		}
		
	}
	
	public List<MemberVO> getMembers(){
		return memberInterface.getMembers();
	}
	
	public MemberVO getMember(int id) {
		return memberInterface.getMember(id);
	}
	
	public int addMember(MemberVO membervo) {
		return memberInterface.addMember(membervo);
	}
	
	public int updateMember(MemberVO membervo){
		return memberInterface.updateMember(membervo);
	}
	
	public int removeMember(int id) {
		return memberInterface.removeMember(id);
	}
}
