package com.blindBattles.BlindBattles.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="students")
public class Student 
{
	@Id
	@Column(unique=true, nullable = false)
	private String accountId;
	@Column(unique = true, nullable = false)
	private String studentId;
	@Column(name="Studentname")
	private String name;
	@Column(name="studentemail", unique = true, nullable = false)
	private String email;
	@Column(name="studentphone")
	private String studentphone;
	@Column(name="studentstatus")
	private boolean status = true; // might be useful in knowing if the student account is active.
	@Column(name="studentpassword", nullable = false)
	private String studentpassword;

	
	//  Getters 
	public String getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getStudentphone() {
		return studentphone;
	}
	public boolean isStatus() {
		return status;
	}
	public String getStudentpassword() {
		return studentpassword;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	
	//  Setters

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	
	
}
