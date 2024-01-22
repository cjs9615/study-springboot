package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.pnu.domain.MemberVO;

public class MemberService {

	private List<MemberVO> list;
	
	public MemberService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5 ; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setPass("1234");
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
		}
	}
	
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
	public MemberVO getMember(Integer id) {
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
	public ResponseEntity<?> addMember(MemberVO memberVO) {
		if (memberVO.getName() == null || memberVO.getPass() == null)
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		memberVO.setId(getNextId());
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return ResponseEntity.ok(memberVO);
	}

	public MemberVO updateMember(MemberVO memberVO) {
		MemberVO fm = findMember(memberVO.getId());
		if(memberVO.getName() != null) fm.setName(memberVO.getName());
		if(memberVO.getPass() != null) fm.setPass(memberVO.getPass());
		return fm;
	}

	public MemberVO deleteMember(Integer id) {
		for(int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if(m.getId() == id) {
				list.remove(i);
				return m;
			}
		}
		return null;
	}
}
