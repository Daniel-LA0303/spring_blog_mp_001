package com.mx.dev.blog.spring_001_blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;
import com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserInfoDTO;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM UserEntity u WHERE u.email = :email")
	boolean existsByEmail(@Param("email") String email);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM UserEntity u WHERE u.username = :username")
	boolean existsByUsername(@Param("username") String username);

	@Query("select ue from UserEntity ue where ue.email = :email")
	Optional<UserEntity> findUserByEmail(@Param("email") String email);

	@Query("select ue from UserEntity ue where ue.username = :username")
	Optional<UserEntity> findUserByUsername(@Param("username") String username);

	@Query("SELECT new com.mx.dev.blog.spring_001_blog.utils.dtos.user.UserInfoDTO(u.userId, u.username, u.email, u.createdAt, u.updatedAt, "
			+ "ui.profilePicture, ui.bio, ui.lastLogin, ui.isActive, ui.phone, ui.direction) "
			+ "FROM UserEntity u JOIN UserInfoEntity ui ON u.userId = ui.userId WHERE u.userId = :userId")
	UserInfoDTO findUserInfoDTO(@Param("userId") Long userId);

}
