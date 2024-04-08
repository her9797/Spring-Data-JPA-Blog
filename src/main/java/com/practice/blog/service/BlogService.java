package com.practice.blog.service;

import com.practice.blog.config.SessionData;
import com.practice.blog.dto.BlogDTO;
import com.practice.blog.dto.CommentDTO;
import com.practice.blog.entity.Blog;
import com.practice.blog.entity.Comment;
import com.practice.blog.repository.BlogRepository;
import com.practice.blog.repository.CommentRepository;
import jakarta.transaction.Transactional;
import jdk.jfr.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    private final ModelMapper modelMapper;

    private final CommentRepository commentRepository;

    private final SessionData sessionData;

    public BlogService(BlogRepository blogRepository, ModelMapper modelMapper, CommentRepository commentRepository, SessionData sessionData) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
        this.sessionData = sessionData;
    }

    /** 블로그 상세 조회  : findById() */
    public BlogDTO findBlogByBlogCode(int blogCode) {

        Blog foundBlog = blogRepository.findById(blogCode).orElseThrow(IllegalAccessError::new);


        sessionData.setSessionAttribute("blogCode", blogCode);

        return modelMapper.map(foundBlog, BlogDTO.class);
    }

    /** 블로그 목록 조회  : findAll() */
    public List<BlogDTO> findBlogList() {

        List<Blog> blogList = blogRepository.findAll();

        return blogList.stream()
                .map(blog -> modelMapper.map(blog, BlogDTO.class))
                .collect(Collectors.toList());

    }

    /** 블로그 신규 등록 : save() */
    public void insert(BlogDTO blogDTO) {

        blogRepository.save(modelMapper.map(blogDTO, Blog.class));

    }

    /** 블로그 수정 */
    @Transactional
    public void modifyBlog(BlogDTO blogDTO) {


        Blog foundBlog = blogRepository.findById(blogDTO.getBlogCode()).orElseThrow(IllegalAccessError::new);

        // Entity 클래스 내부 builder
        foundBlog = foundBlog.content(blogDTO.getContent()).builder();

    }

    /** 블로그 삭제 */
    public void deleteBlog(Integer blogCode) {

        blogRepository.deleteById(blogCode);

    }


    /** 블로그 검색 */
    public List<BlogDTO> findByBlog(String title) {

        List<Blog> blogList = blogRepository.findByTitleContaining(title);

        return blogList.stream()
                .map(blog -> modelMapper.map(blog, BlogDTO.class))
                .collect(Collectors.toList());
    }
}
