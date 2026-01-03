package com.blindBattles.BlindBattles.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blindBattles.BlindBattles.DTO.SubmissionResponse;

@RestController
public class HomeController 
{
	@GetMapping("/")
	public String homePage() {
		return "Blind Battles is running in backend";
	}
	
	
}
