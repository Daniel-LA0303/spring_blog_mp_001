package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.entities.comment.CommentEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.comment.CommentCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

public interface CommentService {

	CommentEntity createComment(CommentCreateRequestDTO commentCreateRequestDTO) throws ServiceException;

	List<CommentEntity> getAllCommentsByBlog(Long blogId) throws ServiceException;

	List<CommentEntity> getAllCommentsByUser(Long userId) throws ServiceException;

	CommentEntity getCommentByIdOrThrow(Long commentId) throws ServiceException;

	CommentEntity getOneComment(Long commentId) throws ServiceException;

	CommentEntity updateComment(CommentCreateRequestDTO commentCreateRequestDTO, Long commentId)
			throws ServiceException;

}
