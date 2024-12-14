package com.mx.dev.blog.spring_001_blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.UserInfoDTO;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("SELECT new com.mx.dev.blog.spring_001_blog.utils.dtos.UserInfoDTO(u.userId, u.username, u.email, u.createdAt, u.updatedAt, "
			+ "ui.profilePicture, ui.bio, ui.lastLogin, ui.isActive, ui.phone, ui.direction) "
			+ "FROM UserEntity u JOIN UserInfoEntity ui ON u.userId = ui.userId WHERE u.userId = :userId")
	UserInfoDTO findUserInfoDTO(@Param("userId") Long userId);

}
