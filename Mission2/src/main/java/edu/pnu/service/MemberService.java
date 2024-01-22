package edu.pnu.service;

import java.util.List;


import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	private MemberDAO memberDAO;

	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	public List<MemberVO> getMembers(){
		return memberDAO.getMembers();
	}
	
	public MemberVO getMember(int id) {
		return memberDAO.getMember(id);
	}
	
	public int addMember(MemberVO membervo) {
		return memberDAO.addMember(membervo);
	}
	
	public int updateMember(MemberVO membervo){
		return memberDAO.updateMember(membervo);
	}
	
	public int removeMember(int id) {
		return memberDAO.removeMember(id);
	}
}
