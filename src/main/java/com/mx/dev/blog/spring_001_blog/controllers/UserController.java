package com.mx.dev.blog.spring_001_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.dev.blog.spring_001_blog.services.UserService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserSimpleResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.response.ApiResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * get all users with a dto
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllCategories() {

		List<UserSimpleResponseDTO> users = userService.getAllUsers();

		ApiResponse<List<UserSimpleResponseDTO>> apiResponse = new ApiResponse<>(
				ResponseStatus.SUCCESS.getHttpStatusCode(), "/api/user", MethodEnum.GET, "Success method GET", users,
				false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	/**
	 * get one simple user
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<?> gteOneSimpleUser(@PathVariable Long userId) throws ServiceException {

		UserSimpleResponseDTO user = userService.getOneUserSimpleInfo(userId);

		ApiResponse<UserSimpleResponseDTO> apiResponse = new ApiResponse<>(ResponseStatus.SUCCESS.getHttpStatusCode(),
				"/api/user", MethodEnum.GET, "Success method GET", user, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
