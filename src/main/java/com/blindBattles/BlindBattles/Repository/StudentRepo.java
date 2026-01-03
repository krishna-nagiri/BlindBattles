package com.blindBattles.BlindBattles.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blindBattles.BlindBattles.Model.Student;

public interface StudentRepo extends JpaRepository<Student, String>
{

	//Find by email.
	Optional<Student> findByEmail(String studentemail);
	
}
