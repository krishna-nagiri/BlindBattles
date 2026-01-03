package com.blindBattles.BlindBattles.service;

import com.blindBattles.BlindBattles.Model.Difficulty;
import com.blindBattles.BlindBattles.Model.Problem;
import com.blindBattles.BlindBattles.Repository.ProblemRepository;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    private final ProblemRepository problemRepo;

    public ProblemService(ProblemRepository problemRepo) {
        this.problemRepo = problemRepo;
    }

    public Problem getRandomProblem(Difficulty difficulty) {
        return problemRepo
                .findRandomByDifficulty(difficulty)
                .orElseThrow(() ->
                        new IllegalStateException("No problems for difficulty " + difficulty));
    }
}
