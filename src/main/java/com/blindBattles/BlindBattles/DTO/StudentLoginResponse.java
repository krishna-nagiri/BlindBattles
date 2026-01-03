package com.blindBattles.BlindBattles.DTO;

public class StudentLoginResponse {

    private String token;
    private String role;
    private String accountId;
    private String name;

    public StudentLoginResponse(String token, String role, String accountId, String name) {
        this.token = token;
        this.role = role;
        this.accountId = accountId;
        this.name = name;
    }

	public String getToken() {
		return token;
	}

	public String getRole() {
		return role;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getName() {
		return name;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
