package com.pulseforge.api.user.dto;

import java.util.UUID;

public record UserResponse(
        Long id,
        String email,
        String name
) {}