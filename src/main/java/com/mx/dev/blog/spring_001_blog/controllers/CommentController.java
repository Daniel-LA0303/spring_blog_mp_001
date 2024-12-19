package com.mx.dev.blog.spring_001_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.dev.blog.spring_001_blog.entities.comment.CommentEntity;
import com.mx.dev.blog.spring_001_blog.services.CommentService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.comment.CommentCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.response.ApiResponse;
import com.mx.dev.blog.spring_001_blog.utils.validators.CommentValidator;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	/**
	 * service
	 */
	@Autowired
	private CommentService commentService;

	/**
	 * validator
	 */
	CommentValidator commentValidator = new CommentValidator();

	/**
	 * get comment by blog
	 * 
	 * @param blogId
	 * @return
	 * @throws ServiceException
	 */
	@GetMapping("/get-comments-by-blog/{blogId}")
	public ResponseEntity<?> getCommentsByBlog(@PathVariable Long blogId) throws ServiceException {

		List<CommentEntity> comments = commentService.getAllCommentsByBlog(blogId);

		ApiResponse<List<CommentEntity>> apiResponse = new ApiResponse<>(ResponseStatus.SUCCESS.getHttpStatusCode(),
				"/api/comment", MethodEnum.GET, "Success method GET", comments, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	/**
	 * get comments by user
	 * 
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	@GetMapping("/get-comments-by-user/{userId}")
	public ResponseEntity<?> getCommentsByUser(@PathVariable Long userId) throws ServiceException {

		List<CommentEntity> comments = commentService.getAllCommentsByUser(userId);

		ApiResponse<List<CommentEntity>> apiResponse = new ApiResponse<>(ResponseStatus.SUCCESS.getHttpStatusCode(),
				"/api/comment", MethodEnum.GET, "Success method GET", comments, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	/**
	 * save a comment
	 * 
	 * @param commentCreateRequestDTO
	 * @return
	 * @throws ServiceException
	 */
	@PostMapping
	public ResponseEntity<?> saveComment(@RequestBody CommentCreateRequestDTO commentCreateRequestDTO)
			throws ServiceException {

		commentValidator.validate(commentCreateRequestDTO);

		CommentEntity commentEntity = commentService.createComment(commentCreateRequestDTO);

		ApiResponse<CommentEntity> apiResponse = new ApiResponse<>(ResponseStatus.CREATED.getHttpStatusCode(),
				"/api/comment", MethodEnum.POST, "Success method POST", commentEntity, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	/**
	 * update a comment
	 * 
	 * @param commentCreateRequestDTO
	 * @param commentId
	 * @return
	 * @throws ServiceException
	 */
	@PutMapping("/{commentId}")
	public ResponseEntity<?> updateComment(@RequestBody CommentCreateRequestDTO commentCreateRequestDTO,
			@PathVariable Long commentId) throws ServiceException {

		commentValidator.validate(commentCreateRequestDTO);

		CommentEntity commentEntity = commentService.updateComment(commentCreateRequestDTO, commentId);

		ApiResponse<CommentEntity> apiResponse = new ApiResponse<>(ResponseStatus.UPDATED.getHttpStatusCode(),
				"/api/comment", MethodEnum.PUT, "Success method PUT", commentEntity, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
