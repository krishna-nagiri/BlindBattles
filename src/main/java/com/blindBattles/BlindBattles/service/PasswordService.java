package com.blindBattles.BlindBattles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String getPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean isValidPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    
    // implement forgot password here.
}
