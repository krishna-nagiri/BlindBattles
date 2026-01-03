package com.blindBattles.BlindBattles.DTO;

import jakarta.validation.constraints.NotBlank;

public class SubmissionRequest {

	@NotBlank(message = "battleId is required")
	private String battleId;

	@NotBlank(message = "language is required")
	private String language;

	@NotBlank(message = "sourceCode cannot be empty")
	private String sourceCode;

    // getters & setters
    
	public String getBattleId() {
		return battleId;
	}

	public String getLanguage() {
		return language;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

    
}
