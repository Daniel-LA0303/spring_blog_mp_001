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

import com.mx.dev.blog.spring_001_blog.entities.reply.ReplyEntity;
import com.mx.dev.blog.spring_001_blog.services.ReplyService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.reply.ReplyCreateRequestDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.response.ApiResponse;
import com.mx.dev.blog.spring_001_blog.utils.validators.ReplyValidator;

@RestController
@RequestMapping("/api/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	private ReplyValidator replyValidator = new ReplyValidator();

	@GetMapping("/get-replies-by-comment/{commentId}")
	public ResponseEntity<?> getCommentsByBlog(@PathVariable Long commentId) throws ServiceException {

		List<ReplyEntity> replies = replyService.getRepliesByComment(commentId);

		ApiResponse<List<ReplyEntity>> apiResponse = new ApiResponse<>(ResponseStatus.SUCCESS.getHttpStatusCode(),
				"/api/comment", MethodEnum.GET, "Success method GET", replies, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> saveReply(@RequestBody ReplyCreateRequestDTO replyCreateRequestDTO)
			throws ServiceException {

		replyValidator.validate(replyCreateRequestDTO);

		ReplyEntity replyEntity = replyService.createReply(replyCreateRequestDTO);

		ApiResponse<ReplyEntity> apiResponse = new ApiResponse<>(ResponseStatus.CREATED.getHttpStatusCode(),
				"/api/reply", MethodEnum.POST, "Success method POST", replyEntity, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/{replyId}")
	public ResponseEntity<?> updateComment(@RequestBody ReplyCreateRequestDTO replyCreateRequestDTO,
			@PathVariable Long replyId) throws ServiceException {

		replyValidator.validate(replyCreateRequestDTO);

		ReplyEntity replyEntity = replyService.updateReply(replyCreateRequestDTO, replyId);

		ApiResponse<ReplyEntity> apiResponse = new ApiResponse<>(ResponseStatus.CREATED.getHttpStatusCode(),
				"/api/reply", MethodEnum.POST, "Success method POST", replyEntity, false);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
