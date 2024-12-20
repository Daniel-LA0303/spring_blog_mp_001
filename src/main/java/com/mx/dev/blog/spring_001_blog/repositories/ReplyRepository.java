package com.mx.dev.blog.spring_001_blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.dev.blog.spring_001_blog.entities.reply.ReplyEntity;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

	/**
	 * get all replies by comment
	 * 
	 * @param commentId
	 * @return
	 */
	@Query("select ce from ReplyEntity ce where ce.commentId = :commentId")
	List<ReplyEntity> findAllRepliesByCommentId(Long commentId);

}
