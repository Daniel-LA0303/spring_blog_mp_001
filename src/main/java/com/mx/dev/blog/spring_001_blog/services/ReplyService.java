package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.entities.reply.ReplyEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.reply.ReplyCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

public interface ReplyService {

	ReplyEntity createReply(ReplyCreateRequestDTO replyCreateRequestDTO) throws ServiceException;

	ReplyEntity getOneReplyOrThrow(Long replyId) throws ServiceException;

	List<ReplyEntity> getRepliesByComment(Long commentId) throws ServiceException;

	ReplyEntity updateReply(ReplyCreateRequestDTO replyCreateRequestDTO, Long replyId) throws ServiceException;

}
