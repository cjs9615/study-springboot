package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.MemberFood;

public interface MemberFoodRepository extends JpaRepository<MemberFood, Long> {

}
