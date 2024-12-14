package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.CategoryException;

public interface CategoryService {

	CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) throws CategoryException;

	List<CategoryResponseDTO> getAllCategories();

	CategoryResponseDTO getOneCategory(Long categoryId) throws CategoryException;

}
