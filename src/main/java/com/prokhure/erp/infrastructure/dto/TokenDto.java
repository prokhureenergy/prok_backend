package com.prokhure.erp.infrastructure.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TokenDto {
    private String partyId;
    private String userRole;
    private String email;
    private String token;
    private String purpose;
    private boolean used;
    private LocalDateTime expirationTime;
}
