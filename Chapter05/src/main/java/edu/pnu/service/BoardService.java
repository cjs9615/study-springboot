package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.persistence.DynamicBoardRepository;

@Service
public class BoardService {
	@Autowired
	private DynamicBoardRepository boardRepo;
	
	//public 
}
