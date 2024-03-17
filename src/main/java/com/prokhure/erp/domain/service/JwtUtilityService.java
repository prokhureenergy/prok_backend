package com.prokhure.erp.domain.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.crypto.SecretKey;

public class JwtUtilityService {
    public static String generateAccessToken(String email, String role, String partyId) {
        return Jwts.builder()
                .claim("email", email)
                .claim("role", role)
                .claim("partyId", partyId)
                .issuedAt(new Date(Instant.now().toEpochMilli()))
                .expiration(new Date(Instant.now().plus(1, ChronoUnit.DAYS).toEpochMilli()))
                .signWith(getKey())
                .compact();
    }

    public static String generateRefreshToken(String email, String role, String partyId) {
        return Jwts.builder()
                .claim("email", email)
                .claim("role", role)
                .claim("partyId", partyId)
                .issuedAt(new Date(Instant.now().toEpochMilli()))
                .expiration(new Date(Instant.now().plus(30, ChronoUnit.DAYS).toEpochMilli()))
                .signWith(getRefreshKey())
                .compact();
    }

    public static String getUsername(String token) {
        return (String) Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("email");
    }

    public static String getUsernameFromRefreshToken(String refreshToken) {
        return (String) Jwts.parser()
                .verifyWith(getRefreshKey())
                .build()
                .parseSignedClaims(refreshToken)
                .getPayload()
                .get("email");
    }


    private static SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    private static SecretKey getRefreshKey() {
        return Keys.hmacShaKeyFor(REFRESH_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    private static final String SECRET_KEY = "as45fg6y7hh7shrimp8923fdf34fg45fg45ht4rg4e34ef";
    private static final String REFRESH_SECRET_KEY = "45545y7hh7shr4545df344st445fg467676ht4rg4e34ef";
}
