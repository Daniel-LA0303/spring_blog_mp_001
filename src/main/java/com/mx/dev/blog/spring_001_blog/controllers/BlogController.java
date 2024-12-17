package com.mx.dev.blog.spring_001_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.dev.blog.spring_001_blog.services.BlogService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.blog.BlogResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.blog.BlogResponsePageDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.response.ApiResponse;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	/**
	 * get all categories with a dto
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllCategories() {

		List<BlogResponseDTO> blogs = blogService.getAllBlogs();

		ApiResponse<List<BlogResponseDTO>> apiResponse = new ApiResponse<>(ResponseStatus.SUCCESS.getHttpStatusCode(),
				"/api/blog", MethodEnum.GET, "Success method GET", blogs, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{blogId}")
	public ResponseEntity<?> getOneCategory(@PathVariable Long blogId) throws ServiceException {

		BlogResponsePageDTO blogResponsePageDTO = blogService.getOneBlog(blogId);

		ApiResponse<BlogResponsePageDTO> apiResponse = new ApiResponse<>(ResponseStatus.SUCCESS.getHttpStatusCode(),
				"/api/blog", MethodEnum.GET, "Success method GET", blogResponsePageDTO, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
