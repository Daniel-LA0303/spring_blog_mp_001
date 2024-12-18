package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

public interface CategoryService {

	CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) throws ServiceException;

	List<CategoryResponseDTO> getAllCategories();

	List<CategoryEntity> getListCategories(List<Long> ids) throws ServiceException;

	CategoryResponseDTO getOneCategory(Long categoryId) throws ServiceException;

	CategoryResponseDTO updateCategroy(CategoryRequestDTO categoryRequestDTO, Long categoryId) throws ServiceException;

}
