package com.practice.blog.service;

import com.practice.blog.config.SessionData;
import com.practice.blog.dto.CommentDTO;
import com.practice.blog.entity.Comment;
import com.practice.blog.repository.BlogRepository;
import com.practice.blog.repository.CommentRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final BlogRepository blogRepository;

    private final ModelMapper modelMapper;

    private final CommentRepository commentRepository;

    private SessionData sessionData;

    public CommentService(BlogRepository blogRepository, ModelMapper modelMapper, CommentRepository commentRepository) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
    }

    public List<CommentDTO> findCommentByBlog(Integer blogCode) {

        List<Comment> comments = commentRepository.findCommentByBlog(blogCode);

        System.out.println("🍟🍟🍟🍟🍟"+blogCode);

        System.out.println("🍔🍔🍔🍔🍔" + comments);


        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDTO.class))
                .collect(Collectors.toList());
    }

    public void insert(CommentDTO commentDTO) {

        commentRepository.save(modelMapper.map(commentDTO, Comment.class));

    }
}
