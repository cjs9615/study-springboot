package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<Board> getBoardList() {
		return (List<Board>) boardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	@Override
	public Board getBoard(Board board) {
		Board b = boardRepo.findById(board.getSeq()).get();
		b.setCnt(b.getCnt() + 1);
		boardRepo.save(b);
		return b;
	}
	
	@Override
	public void updateBoard(Board board) {
		if(board.getSeq() == null) return;
		Optional<Board> option = boardRepo.findById(board.getSeq());
		if(!option.isPresent()) return;
		Board findBoard = option.get();
		if(board.getContent() == null && board.getTitle() == null) return;
		else if(board.getContent() == null) findBoard.setTitle(board.getTitle());
		else if(board.getTitle() == null) findBoard.setContent(board.getContent());
		else {
			findBoard.setTitle(board.getTitle());
			findBoard.setContent(board.getContent());
		}
		boardRepo.save(findBoard);
	}
	
	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}
}
