package com.mx.dev.blog.spring_001_blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.dev.blog.spring_001_blog.entities.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
