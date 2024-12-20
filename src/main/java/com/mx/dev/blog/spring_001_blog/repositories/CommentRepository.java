package com.mx.dev.blog.spring_001_blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.dev.blog.spring_001_blog.entities.comment.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	/**
	 * get all comment by one blog
	 * 
	 * @param blogId
	 * @return
	 */
	@Query("select ce from CommentEntity ce where ce.blogId = :blogId")
	List<CommentEntity> findAllCommentsByBlogId(Long blogId);

	/**
	 * get all comment by one user
	 * 
	 * @param userId
	 * @return
	 */
	@Query("select ce from CommentEntity ce where ce.userId = :userId")
	List<CommentEntity> findAllCommentsByUseId(Long userId);
}
