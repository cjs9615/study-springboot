package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Food;
import edu.pnu.persistence.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepo;
	

	@Override
	public List<Food> searchFoodList(String keyword) {
		return foodRepo.findByNameContaining(keyword);
	}

}
