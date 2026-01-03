package com.blindBattles.BlindBattles.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Problem 
{
	@Id
	@Column(name="problemId", unique=true, nullable=false)
    private String problemId;         		// Unique identifier
   
	@Column(name="title", nullable=false)
	private String title;             		// Problem title
	
	@Column(name="description",nullable=false,length=600)
    private String description;       		// Problem statement

	@Column(nullable=false)
    private int timeLimitSeconds = 2;    	 // Default time limit
	
	@Column(nullable=false)
    private int memoryLimitMb = 256;         // Default memory limit
    
    @Enumerated(EnumType.STRING)
	@Column(name="difficultylevel")
    private Difficulty difficultylevel;		 // Level mapping inside battle

	public String getProblemId() {
		return problemId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getTimeLimitSeconds() {
		return timeLimitSeconds;
	}

	public int getMemoryLimitMb() {
		return memoryLimitMb;
	}

	public Difficulty getDifficultylevel() {
		return difficultylevel;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTimeLimitSeconds(int timeLimitSeconds) {
		this.timeLimitSeconds = timeLimitSeconds;
	}

	public void setMemoryLimitMb(int memoryLimitMb) {
		this.memoryLimitMb = memoryLimitMb;
	}

	public void setDifficultylevel(Difficulty difficultylevel) {
		this.difficultylevel = difficultylevel;
	}
}
