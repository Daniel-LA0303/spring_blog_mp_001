package com.mx.dev.blog.spring_001_blog.utils.dtos.user;

public class JWTAuthResponseDto {

	private String accessToken;

	private String tokenType = "Bearer";

	public JWTAuthResponseDto(String accessToken) {
		this.accessToken = accessToken;
	}

	public JWTAuthResponseDto(String accessToken, String tokenType) {
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setAccessToken(String tokenDeAcceso) {
		this.accessToken = tokenDeAcceso;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
}