package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberInterface {
	private List<MemberVO> list;
	
	public MemberDaoListImpl() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5 ; i++) {
			MemberVO m = MemberVO.builder()
					.id(i)
					.pass("1234")
					.name("name" + i)
					.regidate(new Date())
					.build();
			list.add(m);
		}
	}
	
	@Override
	public List<MemberVO> getMembers() {
		return list;
	}
	
	// id 값 일치하는 멤버 리턴
	private MemberVO findMember(Integer id) {
		for (MemberVO m : list)
			if (m.getId() == id)
				return m;
		return null;
	}

	// get id가 일치하는 멤버 가져오기
	@Override
	public MemberVO getMember(int id) {
		return findMember(id);
	}
	
	
	// id 중 제일 큰 값 찾아서 더하기 1한 값 리턴
	private int getNextId() {
		int mid = -1;
		for (MemberVO m : list)
			if (mid < m.getId())
				mid = m.getId();
		return mid + 1;
	}

	// post member 추가하기
	@Override
	public int addMember(MemberVO memberVO) {
		int result = 0;
		if (memberVO.getName() == null || memberVO.getPass() == null)
			return result;
		memberVO.setId(getNextId());
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		result = 1;
		return result;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		int result = 0;
		MemberVO fm = findMember(memberVO.getId());
		if(memberVO.getName() != null) fm.setName(memberVO.getName());
		if(memberVO.getPass() != null) fm.setPass(memberVO.getPass());
		result = 1;
		return result;
	}

	@Override
	public int removeMember(int id) {
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if(m.getId() == id) {
				list.remove(i);
				result = 1;
				return result;
			}
		}
		return result;
	}
}
