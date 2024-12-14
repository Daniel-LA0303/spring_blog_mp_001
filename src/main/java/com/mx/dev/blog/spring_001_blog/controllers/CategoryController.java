package com.mx.dev.blog.spring_001_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;
import com.mx.dev.blog.spring_001_blog.services.CategoryService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<CategoryEntity> getAllCategories() {

		return categoryService.getAllCategories();
	}

	@GetMapping("/{categoryId}")
	public CategoryResponseDTO getOneCategory(@PathVariable Long categoryId) {
		return categoryService.getOneCategory(categoryId);
	}

}
