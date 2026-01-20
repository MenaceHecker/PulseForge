package com.pulseforge.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET =
            "pulseforge-super-secret-key-pulseforge-super-secret-key";

    private static final long EXPIRATION_MS = 24 * 60 * 60 * 1000;

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
}