package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MemberFood {
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="member_username", nullable=false, updatable=false)
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="food_id", nullable=false, updatable=false)
	private Food food;
	
	private Double gram;
	
	@Default
	private Date eatDate = new Date();
}
