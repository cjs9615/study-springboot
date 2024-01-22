package edu.pnu.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberFoodController {

	@PostMapping("/api/private/save")
	public void saveMemberFood(@RequestBody String s) {
		System.out.println(s);
	}
}
