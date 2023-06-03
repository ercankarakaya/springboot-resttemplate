package com.ercan.clients.QuizPortalClient.pojo;

import lombok.Data;

@Data
public class TokenResponse {

    private String token;
    private String username;
    private String authType;
    private Long tokenExpiryTime;

}
