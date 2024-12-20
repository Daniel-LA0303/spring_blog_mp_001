package com.mx.dev.blog.spring_001_blog.utils.dtos.user;

public class UserUpdateInfoRequestDTO {

	private String profilePicture;

	private String bio;

	private String phone;

	private String direction;

	/**
	 * 
	 */
	public UserUpdateInfoRequestDTO() {
	}

	/**
	 * @param profilePicture
	 * @param bio
	 * @param phone
	 * @param direction
	 */
	public UserUpdateInfoRequestDTO(String profilePicture, String bio, String phone, String direction) {
		this.profilePicture = profilePicture;
		this.bio = bio;
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
