package com.mx.dev.blog.spring_001_blog.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.dev.blog.spring_001_blog.entities.blog.BlogEntity;
import com.mx.dev.blog.spring_001_blog.entities.comment.CommentEntity;
import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.repositories.CommentRepository;
import com.mx.dev.blog.spring_001_blog.services.BlogService;
import com.mx.dev.blog.spring_001_blog.services.CommentService;
import com.mx.dev.blog.spring_001_blog.services.UserService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.comment.CommentCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private BlogService blogService;

	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public CommentEntity createComment(CommentCreateRequestDTO commentCreateRequestDTO) throws ServiceException {

		// 1. first we check if blog exists
		BlogEntity blogEntity = blogService.getBlogByIdOrThrow(commentCreateRequestDTO.getBlogId());

		// 2. we check if user exists
		UserEntity userEntity = userService.getOneUserOrThrow(commentCreateRequestDTO.getUserId());

		CommentEntity commentEntity = new CommentEntity();

		commentEntity.setBlogId(blogEntity.getBlogId());
		commentEntity.setContent(commentCreateRequestDTO.getContent());
		commentEntity.setCreatedAt(LocalDateTime.now());
		commentEntity.setUpdatedAt(LocalDateTime.now());
		commentEntity.setUserId(userEntity.getUserId());

		return commentRepository.save(commentEntity);
	}

	@Override
	public List<CommentEntity> getAllCommentsByBlog(Long blogId) throws ServiceException {

		// 1. first we check if blog exists
		blogService.getBlogByIdOrThrow(blogId);

		return commentRepository.findAllCommentsByBlogId(blogId);
	}

	@Override
	public List<CommentEntity> getAllCommentsByUser(Long userId) throws ServiceException {

		// 1. first check if user exists
		userService.getOneUserOrThrow(userId);

		return commentRepository.findAllCommentsByUseId(userId);
	}

	@Override
	public CommentEntity getCommentByIdOrThrow(Long commentId) throws ServiceException {

		return commentRepository.findById(commentId).orElseThrow(() -> new ServiceException("Comment not found",
				ResponseStatus.NOT_FOUND.getHttpStatusCode(), "/api/comment", MethodEnum.GET));
	}

	@Override
	public CommentEntity getOneComment(Long commentId) throws ServiceException {

		return getCommentByIdOrThrow(commentId);
	}

	@Override
	public CommentEntity updateComment(CommentCreateRequestDTO commentCreateRequestDTO, Long commentId)
			throws ServiceException {

		// 1. first check if comment exists
		CommentEntity commentEntity = getCommentByIdOrThrow(commentId);

		// 2. first we check if blog exists
		blogService.getBlogByIdOrThrow(commentCreateRequestDTO.getBlogId());

		// 3. we check if user exists
		UserEntity userEntity = userService.getOneUserOrThrow(commentCreateRequestDTO.getUserId());

		// 4. we need check if user have permissions
		if (!commentEntity.getUserId().equals(userEntity.getUserId())) {
			throw new ServiceException("You do not have permissions to update this comment",
					ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/comment", MethodEnum.PUT);
		}

		commentEntity.setContent(commentCreateRequestDTO.getContent());
		commentEntity.setUpdatedAt(LocalDateTime.now());

		return commentRepository.save(commentEntity);
	}

}
