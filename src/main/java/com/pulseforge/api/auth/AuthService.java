package com.pulseforge.api.auth;

import com.pulseforge.api.auth.dto.LoginRequest;
import com.pulseforge.api.auth.dto.RegisterRequest;
import com.pulseforge.domain.UserEntity;
import com.pulseforge.domain.enums.Role;
import com.pulseforge.repository.UserRepository;
import com.pulseforge.security.jwt.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalStateException("Email already registered");
        }

        UserEntity user = new UserEntity();
        user.setEmail(request.email());
        user.setName(request.name());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);

        userRepository.save(user);

        return jwtUtil.generateToken(user.getEmail());
    }
    public String login(LoginRequest request) {

        UserEntity user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new IllegalStateException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new IllegalStateException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}