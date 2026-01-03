package com.blindBattles.BlindBattles.DTO;

public class StudentRegisterRequest 
{
	private String studentid;
	private String studentname;
	private String studentemail;
	private String studentphone;
	private String studentpassword;
	
	
	// Getters 
	public String getStudentid() {
		return studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public String getStudentphone() {
		return studentphone;
	}
	public String getStudentpassword() {
		return studentpassword;
	}
	
	// Setters 
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}
	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	
	
}
