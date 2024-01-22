package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	
	List<Food> findByNameContaining(String keyword);
}
