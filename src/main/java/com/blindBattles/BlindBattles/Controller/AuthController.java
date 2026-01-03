package com.blindBattles.BlindBattles.Controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blindBattles.BlindBattles.DTO.LoginRequest;
import com.blindBattles.BlindBattles.DTO.StudentLoginResponse;
import com.blindBattles.BlindBattles.Model.Student;
import com.blindBattles.BlindBattles.DTO.StudentRegisterRequest;
import com.blindBattles.BlindBattles.Repository.StudentRepo;
import com.blindBattles.BlindBattles.config.JwtUtil;
import com.blindBattles.BlindBattles.service.PasswordService;


@RestController
@RequestMapping("/auth")
public class AuthController 
{

    
	private StudentRepo studentRepo;
	private PasswordService passwordservice;
	private JwtUtil jwtUtil;
	
	public AuthController(StudentRepo studentRepo, PasswordService passwordservice, JwtUtil jwtUtil) {
        this.studentRepo = studentRepo;
        this.passwordservice = passwordservice;
        this.jwtUtil = jwtUtil;
      
    }
	
	@PostMapping("/student/Register")
	public ResponseEntity<?> studentRegister(@RequestBody StudentRegisterRequest request)
	{
		if(studentRepo.findByEmail(request.getStudentemail()).isPresent())
		{
			 return ResponseEntity.badRequest().body("Email already exists");
		}
		Student student = new Student();
		student.setStudentId(request.getStudentid());
		student.setName(request.getStudentname());
		student.setEmail(request.getStudentemail());
		student.setStudentpassword(passwordservice.getPassword(request.getStudentpassword()));
		student.setAccountId(UUID.randomUUID().toString());
		student.setStudentphone(request.getStudentphone());
		
		studentRepo.save(student);
		
		 return ResponseEntity.ok("Student registered successfully");
	}
	
	@PostMapping("/student/login")
	public ResponseEntity<?> studentLogin(@RequestBody LoginRequest request) {
//		System.out.println("Email: " + request.getStudentemail());
//		System.out.println("Password: " + request.getStudentpassword());		// Debugging.

	    var optionalStudent = studentRepo.findByEmail(request.getStudentemail());

	    if (optionalStudent.isEmpty()) {
	        return ResponseEntity
	                .status(401)
	                .body("Invalid email or password");
	    }
	    Student currentStudent = optionalStudent.get();
	   
	   if (!passwordservice.isValidPassword(
		        request.getStudentpassword(),
		        currentStudent.getStudentpassword()
		)) {
		    return ResponseEntity.status(401).body("Invalid email or password");
		}


	    String token = jwtUtil.generateToken(
	            currentStudent.getAccountId(),
	            "STUDENT"
	    );

	    StudentLoginResponse response =
	            new StudentLoginResponse(
	                    token,
	                    "STUDENT",
	                    currentStudent.getAccountId(),
	                    currentStudent.getName()
	            );

	    return ResponseEntity.ok(response);
	}


}
