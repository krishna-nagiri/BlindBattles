package com.blindBattles.BlindBattles.service;

import com.blindBattles.BlindBattles.Model.Problem;

public interface JudgeService {

    JudgeResult execute(
            String submissionId,
            String language,
            String sourceCode,
            Problem problem
    );
}
