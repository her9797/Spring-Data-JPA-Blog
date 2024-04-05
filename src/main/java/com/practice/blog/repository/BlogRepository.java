package com.practice.blog.repository;

import com.practice.blog.entity.Blog;
import com.practice.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
