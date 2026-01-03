package com.blindBattles.BlindBattles.DTO;

import com.blindBattles.BlindBattles.Model.Verdict;

public class SubmissionResponse {

    private String submissionId;
    private Verdict verdict;

    private int exitCode;

    private int passedTestCases;
    private int totalTestCases;

    private long executionTimeMs;
    private long memoryUsedMb;
	public String getSubmissionId() {
		return submissionId;
	}
	public Verdict getVerdict() {
		return verdict;
	}
	public int getExitCode() {
		return exitCode;
	}
	public int getPassedTestCases() {
		return passedTestCases;
	}
	public int getTotalTestCases() {
		return totalTestCases;
	}
	public long getExecutionTimeMs() {
		return executionTimeMs;
	}
	public long getMemoryUsedMb() {
		return memoryUsedMb;
	}
	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}
	public void setVerdict(Verdict verdict) {
		this.verdict = verdict;
	}
	public void setExitCode(int exitCode) {
		this.exitCode = exitCode;
	}
	public void setPassedTestCases(int passedTestCases) {
		this.passedTestCases = passedTestCases;
	}
	public void setTotalTestCases(int totalTestCases) {
		this.totalTestCases = totalTestCases;
	}
	public void setExecutionTimeMs(long executionTimeMs) {
		this.executionTimeMs = executionTimeMs;
	}
	public void setMemoryUsedMb(long memoryUsedMb) {
		this.memoryUsedMb = memoryUsedMb;
	}

    
}
