package com.reservation.api.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";
    private int userId;

    public AuthResponseDto(String accessToken, int userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }
}
