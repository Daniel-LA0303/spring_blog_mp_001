package com.mx.dev.blog.spring_001_blog.builders.category;

import java.time.LocalDateTime;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;

public class CategoryBuilder {

	/**
	 * Id
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
	 * updated at
	 */
	private LocalDateTime updatedAt;

	public static CategoryBuilder withAllDummy() {
		return new CategoryBuilder().setCategoryId(1L).setName("Technology").setDescription("All about technology")
				.setColor("#FF5733").setCreatedAt(LocalDateTime.parse("2024-10-11T10:45:00"))
				.setUpdatedAt(LocalDateTime.parse("2024-10-11T10:45:00"));
	}

	public CategoryEntity build() {
		CategoryEntity category = new CategoryEntity();
		category.setCategoryId(categoryId);
		category.setName(name);
		category.setDescription(description);
		category.setColor(color);
		category.setCreatedAt(createdAt);
		category.setUpdatedAt(updatedAt);
		return category;
	}

	public CategoryEntity build2() {
		return new CategoryEntity(categoryId, name, description, color, createdAt, updatedAt);
	}

	/**
	 * Set the value of the property categoryId
	 *
	 * @param categoryId the categoryId to set
	 */
	public CategoryBuilder setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
		return this;
	}

	/**
	 * Set the value of the property color
	 *
	 * @param color the color to set
	 */
	public CategoryBuilder setColor(String color) {
		this.color = color;
		return this;
	}

	/**
	 * Set the value of the property createdAt
	 *
	 * @param createdAt the createdAt to set
	 */
	public CategoryBuilder setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * Set the value of the property description
	 *
	 * @param description the description to set
	 */
	public CategoryBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Set the value of the property name
	 *
	 * @param name the name to set
	 */
	public CategoryBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of the property updatedAt
	 *
	 * @param updatedAt the updatedAt to set
	 */
	public CategoryBuilder setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

}
