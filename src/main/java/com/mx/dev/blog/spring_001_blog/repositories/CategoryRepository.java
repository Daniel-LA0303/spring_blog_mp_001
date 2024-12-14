package com.mx.dev.blog.spring_001_blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.dev.blog.spring_001_blog.entities.ctaegory.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
