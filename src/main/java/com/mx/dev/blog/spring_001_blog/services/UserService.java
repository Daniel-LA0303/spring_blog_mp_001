package com.mx.dev.blog.spring_001_blog.services;

import java.util.List;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.UserInfoDTO;

public interface UserService {

	List<UserEntity> getAllUsers();

	UserInfoDTO getOneUser(Long id);

}
