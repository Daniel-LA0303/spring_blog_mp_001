package com.mx.dev.blog.spring_001_blog.utils.dtos.category;

import java.time.LocalDateTime;

public class CategoryResponseDTO {

	/**
	 * id
	 */
	private Long categoryId;

	/**
	 * name
	 */
	private String name;

	/**
	 * description
	 */
	private String description;

	/**
	 * color
	 */
	private String color;

	/**
	 * created at
	 */
	private LocalDateTime createdAt;

	/**
	 * 
	 */
	public CategoryResponseDTO() {
	}

	/**
	 * @param categoryId
	 * @param name
	 * @param description
	 * @param color
	 * @param createdAt
	 */
	public CategoryResponseDTO(Long categoryId, String name, String description, String color,
			LocalDateTime createdAt) {
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.color = color;
		this.createdAt = createdAt;
	}

	/**
	 * return the value of the property categoryId
	 *
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * return the value of the property color
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
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
	 * return the value of the property name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the value of the property categoryId
	 *
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * set the value of the property color
	 *
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
	 * set the value of the property name
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
