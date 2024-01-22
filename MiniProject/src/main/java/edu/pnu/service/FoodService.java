package edu.pnu.service;

import java.util.List;


import edu.pnu.domain.Food;

public interface FoodService {
	
	List<Food> searchFoodList(String keyword);
}
