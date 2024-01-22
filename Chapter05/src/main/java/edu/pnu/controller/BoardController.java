package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
}
