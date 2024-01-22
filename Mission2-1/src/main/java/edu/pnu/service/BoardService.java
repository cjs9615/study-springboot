package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.BoardDAO;
import edu.pnu.domain.BoardVO;

public class BoardService {

	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public int addBoard(BoardVO boardVO) {
		return boardDAO.addBoard(boardVO);
	}
	
	public List<BoardVO> getBoards() {
		return boardDAO.getBoards();
	}
	
	public BoardVO getBoard(int seq) {
		return boardDAO.getBoard(seq);
	}
	
	public int updateBoard(BoardVO boardVO) {
		return boardDAO.updateBoard(boardVO);
	}
	
	public int removeBoard(int seq) {
		return boardDAO.removeBoard(seq);
	}
}
