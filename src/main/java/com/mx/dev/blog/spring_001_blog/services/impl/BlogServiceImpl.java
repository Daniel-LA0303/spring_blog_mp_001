package com.mx.dev.blog.spring_001_blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.dev.blog.spring_001_blog.entities.blog.BlogEntity;
import com.mx.dev.blog.spring_001_blog.repositories.BlogRepository;
import com.mx.dev.blog.spring_001_blog.repositories.UserRepository;
import com.mx.dev.blog.spring_001_blog.services.BlogService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.UserInfoDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.blog.BlogResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.blog.BlogResponsePageDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.mappers.BlogMappers;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<BlogResponseDTO> getAllBlogs() {

		return BlogMappers.toListBlogResponseDTO(blogRepository.findAll());
	}

	/**
	 * get blog by id, if blog doesn't exists we catch in a exception
	 * 
	 * @param categoryId
	 * @return
	 * @throws ServiceException
	 */
	public BlogEntity getBlogByIdOrThrow(Long blogId) throws ServiceException {

		return blogRepository.findById(blogId).orElseThrow(() -> new ServiceException("Blog not found",
				ResponseStatus.NOT_FOUND.getHttpStatusCode(), "/api/category", MethodEnum.GET));
	}

	@Override
	@Transactional(readOnly = true)
	public BlogResponsePageDTO getOneBlog(Long blogId) throws ServiceException {

		// 1. first search blog by id
		BlogEntity blogEntity = getBlogByIdOrThrow(blogId);

		// 2. then we unit user info
		UserInfoDTO userInfoDTO = userRepository.findUserInfoDTO(blogEntity.getUserId());

		BlogResponsePageDTO blogResponsePageDTO = new BlogResponsePageDTO();
		blogResponsePageDTO.setBlogId(blogEntity.getBlogId());
		blogResponsePageDTO.setContent(blogEntity.getContent());
		blogResponsePageDTO.setCreatedAt(blogEntity.getCreatedAt());
		blogResponsePageDTO.setDescription(blogEntity.getDescription());
		blogResponsePageDTO.setSlug(blogEntity.getSlug());
		blogResponsePageDTO.setStatus(blogEntity.getStatus());
		blogResponsePageDTO.setTitle(blogEntity.getTitle());
		blogResponsePageDTO.setUserInfoDTO(userInfoDTO);

		return blogResponsePageDTO;

	}

}
