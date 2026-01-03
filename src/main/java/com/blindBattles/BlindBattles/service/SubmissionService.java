package com.blindBattles.BlindBattles.service;

import com.blindBattles.BlindBattles.DTO.SubmissionRequest;
import com.blindBattles.BlindBattles.DTO.SubmissionResponse;
import com.blindBattles.BlindBattles.Model.*;
import com.blindBattles.BlindBattles.Repository.*;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepo;
    private final BattleRepository battleRepo;
    private final ProblemRepository problemRepo;
    private final JudgeService judgeService;
    private final ProblemService problemService;

    public SubmissionService(
            SubmissionRepository submissionRepo,
            BattleRepository battleRepo,
            ProblemRepository problemRepo,
            JudgeService judgeService,ProblemService problemService) {

        this.submissionRepo = submissionRepo;
        this.battleRepo = battleRepo;
        this.problemRepo = problemRepo;
        this.judgeService = judgeService;
        this.problemService = problemService;
    }
    private Difficulty mapLevelToDifficulty(int level) {
	    return switch (level) {
	        case 0 -> Difficulty.LEAST;
	        case 1 -> Difficulty.LOW;
	        case 2 -> Difficulty.EASY;
	        case 3 -> Difficulty.MEDIUM;
	        case 4 -> Difficulty.HARD;
	        case 5 -> Difficulty.COMPLEX;
	        default -> Difficulty.PRO;
	    };
	}
    public SubmissionResponse handleSubmission(
            String accountId,
            SubmissionRequest request) {

        // ---------- 1. Validate battle ----------
        Battle battle = battleRepo.findById(request.getBattleId())
                .orElseThrow(() -> new IllegalArgumentException("Battle not found"));

     // ---------- 1. Validate battle ----------
        if (battle.getStatus() != BattleStatus.LIVE) {
            throw new IllegalStateException("Battle is not live");
        }

        // ---------- 2. Determine student level ----------
        int level = determineLevel(accountId, battle.getBattleId());

        // ---------- 3. Select problem ----------
        Difficulty difficulty = mapLevelToDifficulty(level);

        Problem problem = problemRepo
                .findRandomByDifficulty(difficulty)
                .orElseThrow(() ->
                    new IllegalStateException("No problems available for difficulty " + difficulty));


        // ---------- 4. Create submission ----------
        Submission submission = new Submission();
        submission.setSubmissionId(UUID.randomUUID().toString());
        submission.setAccountId(accountId);
        submission.setBattleId(battle.getBattleId());
        submission.setProblemId(problem.getProblemId());
        submission.setLanguage(request.getLanguage());
        submission.setSourceCode(request.getSourceCode());
        submission.setSubmittedAt(LocalDateTime.now());
        submission.setVerdict(null);

        submissionRepo.save(submission);

        // ---------- 5. Judge execution ----------
        JudgeResult result = judgeService.execute(
                submission.getSubmissionId(),
                request.getLanguage(),
                request.getSourceCode(),
                problem
        );

        // ---------- 6. Map verdict ----------
        Verdict verdict = mapVerdict(result.getExitCode());
        submission.setVerdict(verdict);

        submissionRepo.save(submission);

        // ---------- 7. Response ----------
        SubmissionResponse response = new SubmissionResponse();
        response.setSubmissionId(submission.getSubmissionId());
        response.setVerdict(verdict);
        response.setExitCode(result.getExitCode());
        response.setPassedTestCases(result.getPassed());
        response.setTotalTestCases(result.getTotal());
        response.setExecutionTimeMs(result.getExecutionTimeMs());
        response.setMemoryUsedMb(result.getMemoryUsedMb());

        return response;
    }

    private int determineLevel(String accountId, String battleId) {
        // V1 stub
        return 0;
    }

    private Verdict mapVerdict(int exitCode) {
        return switch (exitCode) {
            case 0 -> Verdict.AC;
            case 1 -> Verdict.WA;
            case 124 -> Verdict.TLE;
            case 137 -> Verdict.MLE;
            default -> Verdict.RE;
        };
    }
}
