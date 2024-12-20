package com.mx.dev.blog.spring_001_blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.dev.blog.spring_001_blog.entities.blog.BlogEntity;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

	/**
	 * query to get a boolean if exists one result of slug
	 * 
	 * @param slug
	 * @return
	 */
	@Query("SELECT COUNT(b) > 0 FROM BlogEntity b WHERE b.slug = :slug")
	boolean existsBySlug(String slug);

}
