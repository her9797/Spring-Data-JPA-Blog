package com.practice.blog.controller;

import com.practice.blog.config.SessionData;
import com.practice.blog.dto.CommentDTO;
import com.practice.blog.entity.Comment;
import com.practice.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    private final SessionData sessionData;

    public CommentController(CommentService commentService, SessionData sessionData) {
        this.commentService = commentService;
        this.sessionData = sessionData;
    }


    @GetMapping(value = "/commentByBlog", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CommentDTO> findCommentByBlog(Integer blogCode) {

        blogCode = (Integer) sessionData.getSessionAttribute("blogCode");
        System.out.println("🍔🍔🍚🍚🍚🍚🍚🍚🍔🍔" + blogCode);

        return commentService.findCommentByBlog(blogCode);

    }

    @PostMapping("/comment/insert")
    public String insertComment(CommentDTO commentDTO){

        commentService.insert(commentDTO);

        return "redirect:/";

    }

}
