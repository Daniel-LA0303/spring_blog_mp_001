package com.mx.dev.blog.spring_001_blog.utils.dtos.user;

import java.time.LocalDateTime;

public class UserInfoDTO {

	private Long userId;
	private String username;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String profilePicture;
	private String bio;
	private LocalDateTime lastLogin;
	private Boolean isActive;
	private String phone;
	private String direction;

	/**
	 * 
	 */
	public UserInfoDTO() {
	}

	/**
	 * @param userId
	 * @param username
	 * @param email
	 * @param createdAt
	 * @param updatedAt
	 * @param profilePicture
	 * @param bio
	 * @param lastLogin
	 * @param isActive
	 * @param phone
	 * @param direction
	 */
	public UserInfoDTO(Long userId, String username, String email, LocalDateTime createdAt, LocalDateTime updatedAt,
			String profilePicture, String bio, LocalDateTime lastLogin, Boolean isActive, String phone,
			String direction) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.profilePicture = profilePicture;
		this.bio = bio;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.phone = phone;
		this.direction = direction;
	}

	/**
	 * return the value of the property bio
	 *
	 * @return the bio
	 */
	public String getBio() {
		return bio;
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
	 * return the value of the property direction
	 *
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
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
	 * return the value of the property isActive
	 *
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * return the value of the property lastLogin
	 *
	 * @return the lastLogin
	 */
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	/**
	 * return the value of the property phone
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * return the value of the property profilePicture
	 *
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
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
	 * set the value of the property bio
	 *
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
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
	 * set the value of the property direction
	 *
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
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
	 * set the value of the property isActive
	 *
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * set the value of the property lastLogin
	 *
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * set the value of the property phone
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * set the value of the property profilePicture
	 *
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
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
