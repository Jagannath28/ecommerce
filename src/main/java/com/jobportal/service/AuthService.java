package com.jobportal.service;

import com.jobportal.dto.AuthRequest;
import com.jobportal.dto.AuthResponse;
import com.jobportal.dto.RegisterRequest;
import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import com.jobportal.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest req) {
        User u = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(req.getRole() == null ? "JOB_SEEKER" : req.getRole())
                .build();
        userRepository.save(u);
    }

    public AuthResponse login(AuthRequest req) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        String token = jwtUtil.generateToken(req.getEmail());
        return new AuthResponse(token);
    }
}
