package com.mx.dev.blog.spring_001_blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.dev.blog.spring_001_blog.entities.user.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

	@Query("SELECT u FROM UserInfoEntity u WHERE u.userId = :userId")
	Optional<UserInfoEntity> findUserInfoByUserId(@Param("userId") Long userId);

}
