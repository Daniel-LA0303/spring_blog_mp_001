package com.mx.dev.blog.spring_001_blog.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;
import com.mx.dev.blog.spring_001_blog.repositories.CategoryRepository;
import com.mx.dev.blog.spring_001_blog.services.CategoryService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.CategoryException;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.mappers.CategoryMappers;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) throws ServiceException {

		Optional<CategoryEntity> categoryO = categoryRepository.findCategoryByName(categoryRequestDTO.getName());
		if (categoryO.isPresent()) {
			throw new ServiceException("Category is already exists.", ResponseStatus.BAD_REQUEST.getHttpStatusCode(),
					"/api/category", MethodEnum.POST);
		}

		CategoryEntity categoryEntity = categoryRepository.save(CategoryMappers.toCategoryEntity(categoryRequestDTO));

		return CategoryMappers.fromCategoryEToCategoryEntity(categoryEntity);

	}

	@Override
	public List<CategoryResponseDTO> getAllCategories() {

		return CategoryMappers.toListCategoryResponseDTO(categoryRepository.findAll());
	}

	public CategoryEntity getCategoryByIdOrThrow(Long categoryId) throws CategoryException {

		return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException("Category not found",
				ResponseStatus.NOT_FOUND.getHttpStatusCode(), "/api/category", MethodEnum.GET));
	}

	@Override
	public CategoryResponseDTO getOneCategory(Long categoryId) throws CategoryException {

		CategoryEntity categoryEntity = getCategoryByIdOrThrow(categoryId);

		return CategoryMappers.fromCategoryEToCategoryEntity(categoryEntity);
	}

}
