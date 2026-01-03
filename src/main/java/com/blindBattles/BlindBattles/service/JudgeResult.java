package com.blindBattles.BlindBattles.service;

public class JudgeResult {

    private int exitCode;
    private int passed;
    private int total;
    private long executionTimeMs;
    private long memoryUsedMb;
    
	public int getExitCode() {
		return exitCode;
	}
	public int getPassed() {
		return passed;
	}
	public int getTotal() {
		return total;
	}
	public long getExecutionTimeMs() {
		return executionTimeMs;
	}
	public long getMemoryUsedMb() {
		return memoryUsedMb;
	}
	public void setExitCode(int exitCode) {
		this.exitCode = exitCode;
	}
	public void setPassed(int passed) {
		this.passed = passed;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setExecutionTimeMs(long executionTimeMs) {
		this.executionTimeMs = executionTimeMs;
	}
	public void setMemoryUsedMb(long memoryUsedMb) {
		this.memoryUsedMb = memoryUsedMb;
	}
}
