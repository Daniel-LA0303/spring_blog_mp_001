package com.mx.dev.blog.spring_001_blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.dev.blog.spring_001_blog.config.security.JwtTokenProvider;
import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.services.UserService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.JWTAuthResponseDto;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.LoginDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.response.ApiResponse;
import com.mx.dev.blog.spring_001_blog.utils.validators.UserValidator;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private UserValidator userValidator = new UserValidator();

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO) {
		Authentication authentication = authenticationManager.authenticate(
				new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
						loginDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// obtenemos el token del jwt
		String token = jwtTokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JWTAuthResponseDto(token));
	}

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UserCreateRequestDTO userCreateRequestDTO) throws ServiceException {

		userValidator.validate(userCreateRequestDTO);

		String pass = passwordEncoder.encode(userCreateRequestDTO.getPassword());
		System.out.println("**************");
		System.out.println(pass);
		userCreateRequestDTO.setPassword(pass);

		UserEntity userEntity = userService.createUser(userCreateRequestDTO);

		ApiResponse<UserEntity> apiResponse = new ApiResponse<>(ResponseStatus.CREATED.getHttpStatusCode(), "/api/user",
				MethodEnum.POST, "Success method POST", userEntity, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
