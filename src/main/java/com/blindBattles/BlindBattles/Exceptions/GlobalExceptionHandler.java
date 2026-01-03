package com.blindBattles.BlindBattles.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> badRequest(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error("BAD_REQUEST", e.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> conflict(Exception e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error("INVALID_STATE", e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> serverError(Exception e) {

        e.printStackTrace(); // <-- REQUIRED during development

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error("SERVER_ERROR", e.getMessage()));
    }


    private Map<String, Object> error(String code, String message) {
        return Map.of(
                "timestamp", Instant.now(),
                "error", code,
                "message", message
        );
    }
}
