package com.mx.dev.blog.spring_001_blog.utils.dtos.user;

import java.time.LocalDateTime;

public class UserDetailsDTO {

	/**
	 * profile picture
	 */
	private String profilePicture;

	/**
	 * bio
	 */
	private String bio;

	/**
	 * last login
	 */
	private LocalDateTime lastLogin;

	/**
	 * is active
	 */
	private Boolean isActive;

	/**
	 * phone
	 */
	private String phone;

	/**
	 * direction
	 */
	private String direction;

	/**
	 * 
	 */
	public UserDetailsDTO() {
	}

	/**
	 * @param profilePicture
	 * @param bio
	 * @param lastLogin
	 * @param isActive
	 * @param phone
	 * @param direction
	 */
	public UserDetailsDTO(String profilePicture, String bio, LocalDateTime lastLogin, Boolean isActive, String phone,
			String direction) {
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
	 * return the value of the property direction
	 *
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
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
	 * set the value of the property bio
	 *
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
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

}
