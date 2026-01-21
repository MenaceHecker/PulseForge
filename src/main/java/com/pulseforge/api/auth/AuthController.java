package com.pulseforge.api.auth;

import com.pulseforge.api.auth.dto.AuthResponse;
import com.pulseforge.api.auth.dto.LoginRequest;
import com.pulseforge.api.auth.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return new AuthResponse(authService.register(request));
    }
}