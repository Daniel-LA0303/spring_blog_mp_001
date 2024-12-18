package com.mx.dev.blog.spring_001_blog.utils.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserSimpleResponseDTO;

public class UserMappers {

	public static List<UserSimpleResponseDTO> toListUserSimpleResponseDTO(List<UserEntity> userEntities) {
		return userEntities.stream().map(UserMappers::toUserSimpleResponseDTO).collect(Collectors.toList());
	}

	public static UserSimpleResponseDTO toUserSimpleResponseDTO(UserEntity userEntity) {

		UserSimpleResponseDTO userDTO = new UserSimpleResponseDTO();
		userDTO.setCreatedAt(userEntity.getCreatedAt());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setUserId(userEntity.getUserId());
		userDTO.setUsername(userEntity.getUsername());

		return userDTO;
	}

}
