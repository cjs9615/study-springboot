package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Long calorie;
	
	private Double protein;
	
	private Double fat;
	
	private Double carbohydrates;
	
	private Double sugar;
	
	private Double sodium;
	
	private Double cholesterol;
	
	private Double saturatedfattyacids;
	
	private Double transfattyacids;
}
