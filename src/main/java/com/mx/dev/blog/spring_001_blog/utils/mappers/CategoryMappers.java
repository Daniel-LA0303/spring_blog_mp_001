package com.mx.dev.blog.spring_001_blog.utils.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;

public class CategoryMappers {

	public static CategoryResponseDTO fromCategoryEToCategoryEntity(CategoryEntity categoryEntity) {

		CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

		categoryResponseDTO.setCategoryId(categoryEntity.getCategoryId());
		categoryResponseDTO.setColor(categoryEntity.getColor());
		categoryResponseDTO.setCreatedAt(categoryEntity.getCreatedAt());
		categoryResponseDTO.setDescription(categoryEntity.getDescription());
		categoryResponseDTO.setName(categoryEntity.getName());

		return categoryResponseDTO;
	}

	public static List<CategoryResponseDTO> toListCategoryResponseDTO(List<CategoryEntity> categoriesEntity) {

		return categoriesEntity.stream().map(CategoryMappers::fromCategoryEToCategoryEntity)
				.collect(Collectors.toList());

	}

}
