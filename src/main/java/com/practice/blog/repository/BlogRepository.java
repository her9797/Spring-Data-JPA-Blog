package com.practice.blog.repository;

import com.practice.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    /** 쿼리 메소드 : Containing 을 사용하여 문자열 검색 기능 */
    List<Blog> findByTitleContaining(String title);


}
