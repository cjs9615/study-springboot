package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	private BoardService boardService;
	
	public BoardController() {
		boardService = new BoardService();
	}
	
	@GetMapping("/Board")
	public List<BoardVO> getBoards() {
		return boardService.getBoards();
	}
	
	@GetMapping("/Board/{title}")
	public List<BoardVO> getBoardsTitle(@PathVariable String title) {
		return boardService.getBoardsTitle(title);
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard(Integer seq) {
		return boardService.getBoard(seq);
	}
	
	@GetMapping("/jsongetBoard")
	public BoardVO getBoard1(@RequestBody int seq) {
		return boardService.getBoard(seq);
	}
	
	@PostMapping("/Board")
	public BoardVO addBoard(BoardVO boardVO) {
		return boardService.addBoard(boardVO);
	}
	
	@PutMapping("/Board")
	public BoardVO updateBoard(BoardVO boardVO) {
		return boardService.updateBoard(boardVO);
	}
	
	@DeleteMapping("/Board/{seq}")
	public BoardVO deleteBoard(@PathVariable Integer seq) {
		return boardService.deleteBoard(seq);
	}
	
	@DeleteMapping("/deleteBoard")
	public BoardVO deleteBoard1(Integer seq) {
		return boardService.deleteBoard(seq);
	}
}
