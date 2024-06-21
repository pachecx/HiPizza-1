package com.hipizza.demo.modules.login.dto;

public record LoginResponse(String accessToken, Long expiresIn, Long id) {
}