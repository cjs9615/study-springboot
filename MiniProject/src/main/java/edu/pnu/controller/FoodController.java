package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Food;
import edu.pnu.service.FoodServiceImpl;

@RestController
public class FoodController {
	
	@Autowired
	private FoodServiceImpl foodService;
	
	@PostMapping("/api/public/search")
	public List<Food> searchFoodList(@RequestBody String keyword) {
		return foodService.searchFoodList(keyword);
	}
}
