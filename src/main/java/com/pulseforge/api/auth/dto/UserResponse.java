package com.pulseforge.api.user.dto;

public record UserResponse(
        Long id,
        String email,
        String name
) {}
