package com.mx.dev.blog.spring_001_blog.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.dev.blog.spring_001_blog.entities.blog.BlogEntity;
import com.mx.dev.blog.spring_001_blog.entities.comment.CommentEntity;
import com.mx.dev.blog.spring_001_blog.entities.reply.ReplyEntity;
import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.repositories.ReplyRepository;
import com.mx.dev.blog.spring_001_blog.services.BlogService;
import com.mx.dev.blog.spring_001_blog.services.CommentService;
import com.mx.dev.blog.spring_001_blog.services.ReplyService;
import com.mx.dev.blog.spring_001_blog.services.UserService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.reply.ReplyCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private ReplyRepository replyRepository;

	@Override
	public ReplyEntity createReply(ReplyCreateRequestDTO replyCreateRequestDTO) throws ServiceException {

		// 1. first we need validate if exists user
		UserEntity userEntity = userService.getOneUserOrThrow(replyCreateRequestDTO.getUserId());

		// 2. check if blog exists
		BlogEntity blogEntity = blogService.getBlogByIdOrThrow(replyCreateRequestDTO.getBlogId());

		// 3. check if comment exists
		CommentEntity commentEntity = commentService.getCommentByIdOrThrow(replyCreateRequestDTO.getCommentId());

		// 4. build entity
		ReplyEntity replyEntity = new ReplyEntity();
		replyEntity.setBlogId(blogEntity.getBlogId());
		replyEntity.setCommentId(commentEntity.getCommentId());
		replyEntity.setContent(replyCreateRequestDTO.getContent());
		replyEntity.setCreatedAt(LocalDateTime.now());
		replyEntity.setUpdatedAt(LocalDateTime.now());
		replyEntity.setUserId(userEntity.getUserId());

		return replyRepository.save(replyEntity);
	}

	@Override
	public ReplyEntity getOneReplyOrThrow(Long replyId) throws ServiceException {
		return replyRepository.findById(replyId).orElseThrow(() -> new ServiceException("Reply not found",
				ResponseStatus.NOT_FOUND.getHttpStatusCode(), "/api/reply", MethodEnum.GET));
	}

	@Override
	public List<ReplyEntity> getRepliesByComment(Long commentId) throws ServiceException {

		return replyRepository.findAllRepliesByCommentId(commentId);
	}

	@Override
	public ReplyEntity updateReply(ReplyCreateRequestDTO replyCreateRequestDTO, Long replyId) throws ServiceException {

		// 1. check if reply eixsts
		ReplyEntity replyEntity = getOneReplyOrThrow(replyId);

		// 2. first we need validate if exists user
		UserEntity userEntity = userService.getOneUserOrThrow(replyCreateRequestDTO.getUserId());

		// 3. check if blog exists
		BlogEntity blogEntity = blogService.getBlogByIdOrThrow(replyCreateRequestDTO.getBlogId());

		// 4. check if comment exists
		CommentEntity commentEntity = commentService.getCommentByIdOrThrow(replyCreateRequestDTO.getCommentId());

		// 6. check if user have permissions to update
		if (!replyEntity.getUserId().equals(replyCreateRequestDTO.getUserId())) {
			throw new ServiceException("You do not have permission to update this reply",
					ResponseStatus.BAD_REQUEST.getHttpStatusCode(), "/api/reply", MethodEnum.PUT);
		}

		// 5. build entity
		replyEntity.setBlogId(blogEntity.getBlogId());
		replyEntity.setCommentId(commentEntity.getCommentId());
		replyEntity.setContent(replyCreateRequestDTO.getContent());
		replyEntity.setCreatedAt(LocalDateTime.now());
		replyEntity.setUpdatedAt(LocalDateTime.now());
		replyEntity.setUserId(userEntity.getUserId());

		return replyRepository.save(replyEntity);
	}

}
