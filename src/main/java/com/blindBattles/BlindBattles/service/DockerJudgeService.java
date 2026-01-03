package com.blindBattles.BlindBattles.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.blindBattles.BlindBattles.Model.Problem;

@Service
public class DockerJudgeService implements JudgeService {

    private static final Logger log = LoggerFactory.getLogger(DockerJudgeService.class);
    private static final String BASE_DIR = "/tmp/blindbattles/";

    @Override
    public JudgeResult execute(String submissionId,String language,String sourceCode,Problem problem) 
    {
        Path submissionDir = Paths.get(BASE_DIR, submissionId);

        try {
            Files.createDirectories(submissionDir);

            writeSourceFile(language, submissionDir, sourceCode);
            writeTestCases(submissionDir, problem);
            writeRunner(submissionDir, problem.getTimeLimitSeconds());

            return runDocker(
                    submissionDir,
                    resolveImage(language),
                    problem
            );

        } catch (Exception e) {
            log.error("Judge execution failed for {}", submissionId, e);

            JudgeResult fail = new JudgeResult();
            fail.setExitCode(2); // Runtime error
            return fail;

        } finally {
            cleanup(submissionDir);
        }
    }

    // ----------------- Helpers -----------------

    private void writeSourceFile(
            String language,
            Path dir,
            String sourceCode
    ) throws IOException {

        if (!language.equalsIgnoreCase("JAVA")) {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }

        Files.writeString(dir.resolve("Main.java"), sourceCode);
    }

    private void writeTestCases(Path dir, Problem problem) throws IOException {

        Path inputs = dir.resolve("Inputs");
        Path outputs = dir.resolve("Outputs");

        Files.createDirectories(inputs);
        Files.createDirectories(outputs);

        // v1 stub
        Files.writeString(inputs.resolve("input1.txt"), "2 3\n");
        Files.writeString(outputs.resolve("output1.txt"), "5\n");
    }

    private void writeRunner(Path dir, int timeLimitSeconds) throws IOException {

        String script = """
            #!/bin/bash
            set -e

            javac Main.java

            PASSED=0
            TOTAL=0

            for INPUT in Inputs/input*.txt; do
              TOTAL=$((TOTAL+1))
              ID=$(basename "$INPUT" | sed 's/input//;s/.txt//')

              timeout %ds java Main < "$INPUT" > out.txt

              if diff -q out.txt Outputs/output$ID.txt > /dev/null; then
                PASSED=$((PASSED+1))
              else
                exit 1
              fi
            done

            exit 0
            """.formatted(timeLimitSeconds);

        Path scriptPath = dir.resolve("run.sh");
        Files.writeString(scriptPath, script);
        scriptPath.toFile().setExecutable(true);
    }

    private JudgeResult runDocker(
            Path dir,
            String image,
            Problem problem
    ) throws IOException, InterruptedException {

        List<String> command = List.of(
                "docker", "run", "--rm",
                "--cpus=1",
                "--memory=" + problem.getMemoryLimitMb() + "m",
                "--pids-limit=64",
                "--network=none",
                "-v", dir.toAbsolutePath() + ":/sandbox",
                image,
                "bash", "run.sh"
        );

        long start = System.currentTimeMillis();

        Process process = new ProcessBuilder(command)
                .directory(dir.toFile())
                .start();

        int exitCode = process.waitFor();
        long timeTaken = System.currentTimeMillis() - start;

        JudgeResult result = new JudgeResult();
        result.setExitCode(exitCode);
        result.setExecutionTimeMs(timeTaken);
        result.setMemoryUsedMb(problem.getMemoryLimitMb());
        result.setTotal(1);
        result.setPassed(exitCode == 0 ? 1 : 0);

        return result;
    }

    private String resolveImage(String language) {
        return switch (language.toUpperCase()) {
            case "JAVA" -> "checkingjava-java21";
            // case "PYTHON" -> "checkingpython-3";
            default -> throw new IllegalArgumentException("No image for " + language);
        };
    }

    private void cleanup(Path dir) {
        try {
            if (Files.exists(dir)) {
                Files.walk(dir)
                        .sorted((a, b) -> b.compareTo(a))
                        .forEach(path -> path.toFile().delete());
            }
        } catch (Exception e) {
             log.warn("Failed to cleanup {}", dir, e);
        }
    }
}
