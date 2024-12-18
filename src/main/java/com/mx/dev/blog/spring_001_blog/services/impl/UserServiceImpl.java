package com.mx.dev.blog.spring_001_blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.repositories.UserRepository;
import com.mx.dev.blog.spring_001_blog.services.UserService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserInfoDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserSimpleResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.enums.MethodEnum;
import com.mx.dev.blog.spring_001_blog.utils.enums.ResponseStatus;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;
import com.mx.dev.blog.spring_001_blog.utils.mappers.UserMappers;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserSimpleResponseDTO> getAllUsers() {

		return UserMappers.toListUserSimpleResponseDTO(userRepository.findAll());
	}

	public UserEntity getOneUserOrThrow(Long id) throws ServiceException {
		return userRepository.findById(id).orElseThrow(() -> new ServiceException("User with ID " + id + " not found.",
				ResponseStatus.NOT_FOUND.getHttpStatusCode(), "/api/users", MethodEnum.GET));
	}

	@Override
	public UserSimpleResponseDTO getOneUserSimpleInfo(Long id) throws ServiceException {

		return UserMappers.toUserSimpleResponseDTO(getOneUserOrThrow(id));
	}

	@Override
	public UserInfoDTO getOneUserWithInfo(Long id) throws SecurityException {

		return userRepository.findUserInfoDTO(id);
	}

}
