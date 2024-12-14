package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.repositories.UserRepository;
import com.mx.dev.blog.spring_001_blog.services.impl.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> getAllUsers() {

		return userRepository.findAll();
	}

}
