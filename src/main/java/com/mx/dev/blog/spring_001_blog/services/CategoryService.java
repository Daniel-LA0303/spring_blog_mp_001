package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

public interface CategoryService {

	CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) throws ServiceException;

	List<CategoryResponseDTO> getAllCategories();

	CategoryResponseDTO getOneCategory(Long categoryId) throws ServiceException;

	CategoryResponseDTO updateCategroy(CategoryRequestDTO categoryRequestDTO, Long categoryId) throws ServiceException;

}
