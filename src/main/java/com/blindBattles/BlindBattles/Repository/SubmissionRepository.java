package com.blindBattles.BlindBattles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blindBattles.BlindBattles.Model.Submission;

public interface SubmissionRepository  extends JpaRepository<Submission, String>{

}
