package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogH2Impl;
import edu.pnu.dao.MemberH2Impl;
//import edu.pnu.dao.MemberListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	private MemberInterface memberInterface;
	private LogH2Impl logH2Impl;

	public MemberService(Environment environment) {
		String type = environment.getProperty("service.type");
		
		if(type != null && type.equals("h2")) {
			System.out.println("h2");
			memberInterface = new MemberH2Impl();
			logH2Impl = new LogH2Impl();
		}
		else {
			System.out.println("list");
//			memberInterface = new MemberListImpl();
		}
		
	}
	
	public List<MemberVO> getMembers(){
		Map<String, Object> map = memberInterface.getMembers();
		List<MemberVO> list = (List<MemberVO>) map.get("data");
		logH2Impl.addLog("get", map.get("sql").toString(), list);
		return list;
	}
	
	public MemberVO getMember(int id) {
		Map<String, Object> map = memberInterface.getMember(id);
		MemberVO m = (MemberVO) map.get("data");
		logH2Impl.addLog("get", map.get("sql").toString(), m);
		return m;
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
