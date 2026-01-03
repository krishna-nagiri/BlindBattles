package com.blindBattles.BlindBattles.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blindBattles.BlindBattles.Model.Difficulty;
import com.blindBattles.BlindBattles.Model.Problem;

public interface ProblemRepository extends JpaRepository<Problem, String> {

    @Query("""
        SELECT p FROM Problem p
        WHERE p.difficultylevel = :difficulty
        ORDER BY RANDOM()
        LIMIT 1
    """)
    Optional<Problem> findRandomByDifficulty(Difficulty difficulty);
}
