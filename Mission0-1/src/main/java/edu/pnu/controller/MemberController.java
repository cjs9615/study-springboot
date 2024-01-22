package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	List<MemberVO> list;
	
	public MemberController() {
		list = new ArrayList<>();
		int idx = 1;
		for(int i=1; i <= 5; i++) {
			//기본 생성자를 이용한 객체 생성
			MemberVO m = new MemberVO();
			m.setId(idx);
			m.setName("name" + idx);
			m.setPass("pass"+ idx);
			m.setRegidate(new Date());
			list.add(m);
			idx++;
			
			//모든 파라미터를 필요로 하는 생성자를 이용한 객체 생성
			MemberVO m1 = new MemberVO(idx, "pass" + idx, "name" + idx, new Date());
			list.add(m1);
			idx++;
			
			//빌터 패턴을 이용한 객체 생성
			list.add(MemberVO.builder()
					.id(idx)
					.name("name" + idx)
					.pass("pass" + idx)
					.regidate(new Date())
					.build()
					);
			idx++;
		}
	}
	
	//get 멤버전체 가져오기
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return list;
	}

	//id 값 일치하는 멤버 리턴
	private MemberVO findMember(Integer id) {
		for(MemberVO m : list)
			if(m.getId() == id)
				return m;
		return null;
	}
	
	//get id가 일치하는 멤버 가져오기
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return findMember(id);
	}
	
	//id 중 제일 큰 값 찾아서 더하기 1한 값 리턴
	private int getNextId() {
		int mid = -1;
		for(MemberVO m : list)
			if(mid < m.getId()) mid = m.getId();
		return mid + 1;
	}
	
	//post member 추가하기
	@PostMapping("/member")
	public ResponseEntity<?> addMember(MemberVO memberVO) {
		if(memberVO.getName() == null || memberVO.getPass() == null) return (ResponseEntity<?>) ResponseEntity.badRequest();
		memberVO.setId(getNextId());
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return ResponseEntity.ok(memberVO);
	}
	
	//put member 수정하기
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		MemberVO fm = findMember(memberVO.getId());
		if(memberVO.getName() != null) fm.setName(memberVO.getName());
		if(memberVO.getPass() != null) fm.setPass(memberVO.getPass());
		return fm;
	}
	
	//delete member 삭제하기
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
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
