package com.practice.blog.service;

import com.practice.blog.dto.BlogDTO;
import com.practice.blog.entity.Blog;
import com.practice.blog.repository.BlogRepository;
import com.practice.blog.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    private final ModelMapper modelMapper;

    private final CommentRepository commentRepository;

    public BlogService(BlogRepository blogRepository, ModelMapper modelMapper, CommentRepository commentRepository) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
    }

    /** 블로그 상세 조회  : findById() */
    public BlogDTO findBlogByBlogCode(int blogCode) {

        Blog foundBlog = blogRepository.findById(blogCode).orElseThrow(IllegalAccessError::new);

        return modelMapper.map(foundBlog, BlogDTO.class);
    }

    /** 블로그 목록 조회  : findAll() */
    public List<BlogDTO> findBlogList() {

        List<Blog> blogList = blogRepository.findAll();

        return blogList.stream()
                .map(blog -> modelMapper.map(blog, BlogDTO.class))
                .collect(Collectors.toList());

    }
}
