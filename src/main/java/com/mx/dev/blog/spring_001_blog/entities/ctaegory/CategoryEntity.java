package com.mx.dev.blog.spring_001_blog.entities.ctaegory;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_tbl")
public class CategoryEntity {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	/**
	 * name
	 */
	@Column(name = "name")
	private String name;

	/**
	 * description
	 */
	@Column(name = "description")
	private String description;

	/**
	 * color
	 */
	@Column(name = "color")
	private String color;

	/**
	 * created at
	 */
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	/**
	 * updated at
	 */
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	/**
	 * 
	 */
	public CategoryEntity() {
	}

	/**
	 * @param categoryId
	 * @param name
	 * @param description
	 * @param color
	 * @param createdAt
	 * @param updatedAt
	 */
	public CategoryEntity(Long categoryId, String name, String description, String color, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.color = color;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	 * return the value of the property updatedAt
	 *
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
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

	/**
	 * set the value of the property updatedAt
	 *
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
