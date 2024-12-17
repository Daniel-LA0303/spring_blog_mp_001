package com.mx.dev.blog.spring_001_blog.utils.dtos.blog;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.dev.blog.spring_001_blog.utils.dtos.UserInfoDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.BlogStatusEnum;

public class BlogResponsePageDTO {

	/**
	 * id
	 */
	private Long blogId;

	/**
	 * title
	 */
	private String title;

	/**
	 * description
	 */
	private String description;

	/**
	 * content
	 */
	private String content;

	/**
	 * status
	 */
	private BlogStatusEnum status;

	/**
	 * slug
	 */
	private String slug;

	/**
	 * created at
	 */
	private LocalDateTime createdAt;

	/**
	 * user id
	 */
	@JsonProperty("userInfo")
	private UserInfoDTO userInfoDTO;

	/**
	 * 
	 */
	public BlogResponsePageDTO() {
	}

	/**
	 * @param blogId
	 * @param title
	 * @param description
	 * @param content
	 * @param status
	 * @param slug
	 * @param createdAt
	 * @param userInfoDTO
	 */
	public BlogResponsePageDTO(Long blogId, String title, String description, String content, BlogStatusEnum status,
			String slug, LocalDateTime createdAt, UserInfoDTO userInfoDTO) {
		this.blogId = blogId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.status = status;
		this.slug = slug;
		this.createdAt = createdAt;
		this.userInfoDTO = userInfoDTO;
	}

	/**
	 * return the value of the property blogId
	 *
	 * @return the blogId
	 */
	public Long getBlogId() {
		return blogId;
	}

	/**
	 * return the value of the property content
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
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
	 * return the value of the property description
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * return the value of the property slug
	 *
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * return the value of the property status
	 *
	 * @return the status
	 */
	public BlogStatusEnum getStatus() {
		return status;
	}

	/**
	 * return the value of the property title
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * return the value of the property userInfoDTO
	 *
	 * @return the userInfoDTO
	 */
	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	/**
	 * set the value of the property blogId
	 *
	 * @param blogId the blogId to set
	 */
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	/**
	 * set the value of the property content
	 *
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * set the value of the property description
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * set the value of the property slug
	 *
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * set the value of the property status
	 *
	 * @param status the status to set
	 */
	public void setStatus(BlogStatusEnum status) {
		this.status = status;
	}

	/**
	 * set the value of the property title
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * set the value of the property userInfoDTO
	 *
	 * @param userInfoDTO the userInfoDTO to set
	 */
	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

}
