package com.blindBattles.BlindBattles.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    private String submissionId;

    @Column(nullable = false)
    private String accountId; // from JWT (student)

    @Column(nullable = false)
    private String battleId;

    @Column(nullable = false)
    private String problemId;

    @Column(nullable = false)
    private String language;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String sourceCode;

    @Enumerated(EnumType.STRING)
    private Verdict verdict; // null initially

    @Column(nullable = false)
    private LocalDateTime submittedAt;

	public String getSubmissionId() {
		return submissionId;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getBattleId() {
		return battleId;
	}

	public String getProblemId() {
		return problemId;
	}

	public String getLanguage() {
		return language;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public Verdict getVerdict() {
		return verdict;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public void setVerdict(Verdict verdict) {
		this.verdict = verdict;
	}

	public void setSubmittedAt(LocalDateTime localDateTime) {
		this.submittedAt = localDateTime;
	}
    
    
}

