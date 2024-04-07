package com.practice.blog.repository;

import com.practice.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT comment_code, comment, comment_date, comment_id from comment ORDER BY comment_code", nativeQuery = true)
    List<Comment> findAllComment();

    @Query(value = "SELECT COMMENT_CODE, COMMENT, COMMENT_DATE, COMMENT_ID, BLOG_CODE FROM COMMENT", nativeQuery = true)
    List<Comment> findCommentByBlog();
}
