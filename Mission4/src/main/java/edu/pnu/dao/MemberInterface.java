package edu.pnu.dao;

import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {

	int addMember(MemberVO membervo);

	Map<String, Object> getMembers();

	Map<String, Object> getMember(int id);

	int updateMember(MemberVO membervo);

	int removeMember(int id);

}