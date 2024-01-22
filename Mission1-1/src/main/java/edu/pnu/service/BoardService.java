package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.BoardVO;

public class BoardService {
	
	private List<BoardVO> list;
	
	public BoardService() {
		list = new ArrayList<>();
		for(int i = 1; i <= 5; i++) {
			list.add(
					BoardVO.builder()
					.seq(i)
					.title("title" + i)
					.content("content" + i)
					.writer("writer" + i)
					.createDate(new Date())
					.cnt(0)
					.build()
			);
		}
	}

	//보드 전체 가져오기
	public List<BoardVO> getBoards() {
		// TODO Auto-generated method stub
		return list;
	}
	
	//검색한 title 과 일부 일치하는 보드 리스트 리턴
	private List<BoardVO> findBoards(String title) {
		List<BoardVO> l = new ArrayList<>();
		for(BoardVO b : list)
			if(b.getTitle().contains(title)) {
				l.add(b);
			}
		return l;
	}

	//검색한 title 과 일부 일치하는 보드 전체 가져오기
	public List<BoardVO> getBoardsTitle(String title) {
		// TODO Auto-generated method stub
		return findBoards(title);
	}
	
	private int getNextSeq() {
		int mid = -1;
		for(BoardVO b : list) {
			if(mid < b.getSeq()) mid = b.getSeq();
		}
		return mid + 1;
	}

	//보드 추가하기
	public BoardVO addBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardVO.setSeq(getNextSeq());
		boardVO.setCreateDate(new Date());
		boardVO.setCnt(0);
		list.add(boardVO);
		return boardVO;
	}
	
	private BoardVO findBoard(Integer seq) {
		for(BoardVO b : list)
			if(b.getSeq() == seq) return b;
		return null;
	}

	//보드 수정하기
	public BoardVO updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		BoardVO fb = findBoard(boardVO.getSeq());
		if(boardVO.getTitle() != null) fb.setTitle(boardVO.getTitle());
		if(boardVO.getContent() != null) fb.setContent(boardVO.getContent());
		return fb;
	}

	public BoardVO deleteBoard(Integer seq) {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++) {
			BoardVO b = list.get(i);
			if(b.getSeq() == seq) {
				list.remove(i);
				return b;
			}
		}
		return null;
	}

	public BoardVO getBoard(Integer seq) {
		// TODO Auto-generated method stub
		return findBoard(seq);
	}


}
