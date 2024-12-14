package com.mx.dev.blog.spring_001_blog.utils.dtos;

import java.time.LocalDateTime;

public class UserDTO {

	/**
	 * user id
	 */
	private Long userId;

	/**
	 * username
	 */
	private String username;

	/**
	 * email
	 */
	private String email;

	/**
	 * password
	 */
	private String password;

	/**
	 * user details
	 */
	private UserDetailsDTO userDetailsDTO;

	/**
	 * created at
	 */
	private LocalDateTime createdAt;

	/**
	 * updated at
	 */
	private LocalDateTime updatedAt;

	/**
	 * 
	 */
	public UserDTO() {
	}

	/**
	 * @param userId
	 * @param username
	 * @param email
	 * @param password
	 * @param userDetailsDTO
	 * @param createdAt
	 * @param updatedAt
	 */
	public UserDTO(Long userId, String username, String email, String password, UserDetailsDTO userDetailsDTO,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userDetailsDTO = userDetailsDTO;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * return the value of the property createdAt
	 *
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * return the value of the property email
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * return the value of the property password
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * return the value of the property updatedAt
	 *
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * return the value of the property userDetailsDTO
	 *
	 * @return the userDetailsDTO
	 */
	public UserDetailsDTO getUserDetailsDTO() {
		return userDetailsDTO;
	}

	/**
	 * return the value of the property userId
	 *
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * return the value of the property username
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * set the value of the property createdAt
	 *
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * set the value of the property email
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * set the value of the property password
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * set the value of the property updatedAt
	 *
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * set the value of the property userDetailsDTO
	 *
	 * @param userDetailsDTO the userDetailsDTO to set
	 */
	public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
		this.userDetailsDTO = userDetailsDTO;
	}

	/**
	 * set the value of the property userId
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * set the value of the property username
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
