package com.practice.blog.repository;

import com.practice.blog.dto.CommentDTO;
import com.practice.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT comment_code, comment, comment_date, comment_id from comment ORDER BY comment_code", nativeQuery = true)
    List<Comment> findAllComment();

    @Query(value = "SELECT c.COMMENT_CODE ,c.COMMENT, c.COMMENT_DATE, c.COMMENT_ID, c.BLOG_CODE FROM COMMENT c JOIN BLOG b ON c.BLOG_CODE = b.BLOG_CODE WHERE b.BLOG_CODE = :blogCode", nativeQuery = true)
    List<Comment> findCommentByBlog(@Param("blogCode")Integer blogCode);
}
