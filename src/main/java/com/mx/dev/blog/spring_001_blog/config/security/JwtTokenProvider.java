package com.mx.dev.blog.spring_001_blog.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	@Value("${app.jwt.expiration-in-ms}")
	private int jwtExpirationInMs;

	/**
	 * generate a token
	 * 
	 * @param authentication
	 * @return
	 */
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date actualDate = new Date();
		Date expirationDate = new Date(actualDate.getTime() + jwtExpirationInMs);

		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate)
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, jwtSecret).compact();

		return token;
	}

	/**
	 * get username
	 * 
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {

		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	/**
	 * validate a token
	 * 
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public boolean validateToken(String token) throws ServiceException {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);

			return true;
		} catch (SignatureException ex) {
			throw new ServiceException("Token Error", ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/auth",
					MethodEnum.POST);
		} catch (MalformedJwtException ex) {
			throw new ServiceException("Invalid Token", ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/auth",
					MethodEnum.POST);
		} catch (ExpiredJwtException ex) {
			throw new ServiceException("Expired Token", ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/auth",
					MethodEnum.POST);
		} catch (UnsupportedJwtException ex) {
			throw new ServiceException("Invalid Token", ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/auth",
					MethodEnum.POST);
		} catch (IllegalArgumentException ex) {
			throw new ServiceException("Expired Token", ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/auth",
					MethodEnum.POST);
		}

	}
}