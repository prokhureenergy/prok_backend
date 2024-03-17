package com.prokhure.erp.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDto {
private String userUuid;
private String email;
private String password;
private String passwordHash;
private String userRole;
    public AuthenticationDto(String userUuid, String email, String password, String passwordHash, String userRole) {
        this.userUuid = userUuid;
        this.email = email;
        this.password = password;
        this.passwordHash = passwordHash;
        this.userRole = userRole;
    }
}
