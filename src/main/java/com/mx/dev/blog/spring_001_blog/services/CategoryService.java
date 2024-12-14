package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;

public interface CategoryService {

	CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);

	List<CategoryEntity> getAllCategories();

	CategoryResponseDTO getOneCategory(Long categoryId);

}
