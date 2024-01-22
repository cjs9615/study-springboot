package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {

	int addMember(MemberVO membervo);

	List<MemberVO> getMembers();

	MemberVO getMember(int id);

	int updateMember(MemberVO membervo);

	int removeMember(int id);

}