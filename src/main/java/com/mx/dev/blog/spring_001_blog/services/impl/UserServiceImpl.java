package com.mx.dev.blog.spring_001_blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.repositories.UserInfoRepository;
import com.mx.dev.blog.spring_001_blog.repositories.UserRepository;
import com.mx.dev.blog.spring_001_blog.services.UserService;
import com.mx.dev.blog.spring_001_blog.utils.dtos.UserInfoDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public List<UserEntity> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public UserInfoDTO getOneUser(Long id) {

		return userRepository.findUserInfoDTO(id);
	}

}
