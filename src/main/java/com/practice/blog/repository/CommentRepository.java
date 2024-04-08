package com.practice.blog.repository;

import com.practice.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT comment_code, comment, comment_date, comment_id from comment ORDER BY comment_code", nativeQuery = true)
    List<Comment> findAllComment();

    @Query(value = "SELECT c.*, b.TITLE, b.CONTENT, b.BLOG_ID\n" +
            "FROM COMMENT c\n" +
            "JOIN BLOG b ON c.BLOG_CODE = b.BLOG_CODE\n" +
            "WHERE b.BLOG_CODE = c.BLOG_CODE;", nativeQuery = true)
    List<Comment> findCommentByBlog();
}
