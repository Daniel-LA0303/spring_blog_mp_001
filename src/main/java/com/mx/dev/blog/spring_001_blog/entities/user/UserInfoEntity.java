package com.mx.dev.blog.spring_001_blog.entities.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info_tbl")
public class UserInfoEntity {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userInfoId;

	/**
	 * profile picture
	 */
	@Column(name = "profile_picture")
	private String profilePicture;

	/**
	 * bio
	 */
	@Column(name = "bio")
	private String bio;

	/**
	 * last login
	 */
	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	/**
	 * is active
	 */
	@Column(name = "is_active")
	private Boolean isActive;

	/**
	 * phone
	 */
	@Column(name = "phone")
	private String phone;

	/**
	 * direction
	 */
	@Column(name = "direction")
	private String direction;

	/**
	 * user id
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 
	 */
	public UserInfoEntity() {
	}

	/**
	 * @param userInfoId
	 * @param profilePricture
	 * @param bio
	 * @param lastLogin
	 * @param isActive
	 * @param phone
	 * @param direction
	 * @param userId
	 */
	public UserInfoEntity(Long userInfoId, String profilePricture, String bio, LocalDateTime lastLogin,
			Boolean isActive, String phone, String direction, Long userId) {
		this.userInfoId = userInfoId;
		this.profilePicture = profilePricture;
		this.bio = bio;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.phone = phone;
		this.direction = direction;
		this.userId = userId;
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
	 * return the value of the property profilePricture
	 *
	 * @return the profilePricture
	 */
	public String getProfilePicture() {
		return profilePicture;
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
	 * return the value of the property userInfoId
	 *
	 * @return the userInfoId
	 */
	public Long getUserInfoId() {
		return userInfoId;
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
	 * set the value of the property profilePricture
	 *
	 * @param profilePricture the profilePricture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
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
	 * set the value of the property userInfoId
	 *
	 * @param userInfoId the userInfoId to set
	 */
	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

}
