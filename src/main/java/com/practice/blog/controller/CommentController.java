package com.practice.blog.controller;

import com.practice.blog.dto.CommentDTO;
import com.practice.blog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping(value = "/commentByBlog", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CommentDTO> findCommentByBlog() {

        return commentService.findCommentByBlog();

    }

    @PostMapping("/comment/insert")
    public String insertComment(CommentDTO commentDTO){

        commentService.insert(commentDTO);

        return "redirect:/";

    }

}
