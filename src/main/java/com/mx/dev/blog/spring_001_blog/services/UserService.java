package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserInfoDTO;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserSimpleResponseDTO;
import com.mx.dev.blog.spring_001_blog.utils.exceptions.ServiceException;

public interface UserService {

	List<UserSimpleResponseDTO> getAllUsers();

	UserEntity getOneUserOrThrow(Long id) throws ServiceException;

	UserSimpleResponseDTO getOneUserSimpleInfo(Long id) throws ServiceException;

	UserInfoDTO getOneUserWithInfo(Long id) throws ServiceException;

}
