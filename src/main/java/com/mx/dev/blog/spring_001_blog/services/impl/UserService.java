package com.mx.dev.blog.spring_001_blog.services.impl;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;

public interface UserService {

	List<UserEntity> getAllUsers();

}
