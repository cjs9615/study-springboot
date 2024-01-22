package edu.pnu.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {
	// insert Post select Get update Post delete Delete
	List<MemberVO> list;
	
	public MemberController() {
		list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
		}
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return list;
	}
	
	private MemberVO findMember(Integer id) {
		for(MemberVO m : list) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}

	// MemberVO에서 id가 {id}인 데이터를 찾아서 리턴
	// http://localhost:8080/member/5 ==> id가 5인 데이터를 찾아서 돌려 달라.
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return findMember(id);
	}
	
	// MemberVO에서 id가 {id}인 데이터를 찾아서 리턴
	// http://localhost:8080/member?id=5 ==> id가 5인 데이터를 찾아서 돌려 달라.
	@GetMapping("/getmember")
	public MemberVO getMember1(Integer id) {
		return findMember(id);
	}
	
	// 현재 입력되어 있는 객체들의 id를 조사해서 최대값에 1을 더해서
	// 다음 추가되는 데이터의 id를 만들어서 넘겨준다.
	private int getNextId() {
		int mid = -1;
		for(MemberVO m : list) {
			if (mid < m.getId()) mid = m.getId();
		}
		return mid + 1;
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		if(memberVO.getName() == null || memberVO.getPass() == null) return null;
		memberVO.setId(getNextId());
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
	
	@PostMapping("/member1")
	public ResponseEntity<?> addMember1(MemberVO memberVO) {
		if(memberVO.getName() == null || memberVO.getPass() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(memberVO);
		}
		memberVO.setId(getNextId());
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return ResponseEntity.status(HttpStatus.OK).body(memberVO);
	}

	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		MemberVO fm = findMember(memberVO.getId());
		if (memberVO.getName() != null) fm.setName(memberVO.getName());
		if (memberVO.getPass() != null) fm.setPass(memberVO.getPass());
		
		return fm;
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		for (int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if(m.getId() == id) {
				list.remove(i);
				return m;
			}
		}
		return null;
	}


}
