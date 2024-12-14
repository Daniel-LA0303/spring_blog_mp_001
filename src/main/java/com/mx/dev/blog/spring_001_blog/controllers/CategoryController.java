package com.mx.dev.blog.spring_001_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.dev.blog.spring_001_blog.services.CategoryService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.category.CategoryResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.CategoryException;
import com.mx.dev.blog.spring_001_blog.utils.response.ApiResponse;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> getAllCategories() {

		List<CategoryResponseDTO> categories = categoryService.getAllCategories();

		ApiResponse<List<CategoryResponseDTO>> apiResponse = new ApiResponse<>(
				ResponseStatus.SUCCESS.getHttpStatusCode(), "/api/category", MethodEnum.GET, "Success method GET",
				categories, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getOneCategory(@PathVariable Long categoryId) throws CategoryException {

		CategoryResponseDTO categoryResponseDTO = categoryService.getOneCategory(categoryId);

		ApiResponse<CategoryResponseDTO> apiResponse = new ApiResponse<>(ResponseStatus.SUCCESS.getHttpStatusCode(),
				"/api/category", MethodEnum.GET, "Success method GET", categoryResponseDTO, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
