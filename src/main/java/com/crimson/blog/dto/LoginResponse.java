package com.crimson.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class LoginResponse {
    private String token;
    private String username;
    private long expiresInMs;
}
