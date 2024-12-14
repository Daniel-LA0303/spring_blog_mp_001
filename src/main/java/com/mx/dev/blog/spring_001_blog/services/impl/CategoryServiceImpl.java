package com.mx.dev.blog.spring_001_blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;
import com.mx.dev.blog.spring_001_blog.repositories.CategoryRepository;
import com.mx.dev.blog.spring_001_blog.services.CategoryService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.mappers.CategoryMappers;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {

		return null;
	}

	@Override
	public List<CategoryEntity> getAllCategories() {

		return categoryRepository.findAll();
	}

	@Override
	public CategoryResponseDTO getOneCategory(Long categoryId) {

		return CategoryMappers.fromCategoryEToCategoryEntity(categoryRepository.findById(categoryId).orElseThrow(null));
	}

}
