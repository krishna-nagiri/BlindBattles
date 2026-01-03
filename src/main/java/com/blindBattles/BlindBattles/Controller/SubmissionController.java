package com.blindBattles.BlindBattles.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blindBattles.BlindBattles.DTO.SubmissionRequest;
import com.blindBattles.BlindBattles.DTO.SubmissionResponse;
import com.blindBattles.BlindBattles.service.SubmissionService;

@RestController
@RequestMapping("/api")
public class SubmissionController 
{
	private final SubmissionService submissionService;
	
	public SubmissionController(SubmissionService submissionService) {
		this.submissionService = submissionService;
	}
	
	@PostMapping("/submission")
	public ResponseEntity<SubmissionResponse> submit(
			@RequestBody SubmissionRequest request, 
			Authentication authentication)
	{
		String accountId = authentication.getName();
		SubmissionResponse response = submissionService.handleSubmission(accountId, request);
		return ResponseEntity.ok(response);
	}
}
