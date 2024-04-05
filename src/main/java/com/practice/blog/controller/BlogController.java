package com.practice.blog.controller;

import com.practice.blog.dto.BlogDTO;
import com.practice.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    /** 상세 조회 */
    @GetMapping("/blog/{blogCode}")
    public String findBlogByCode(@PathVariable int blogCode, Model model){

        BlogDTO blog = blogService.findBlogByBlogCode(blogCode);

        model.addAttribute("blog", blog);

        return "/blog/detail";
    }

    /** 리스트 */
    @GetMapping("/")
    public String findBlogList(Model model){

        List<BlogDTO> blogList = blogService.findBlogList();

        model.addAttribute("blogList", blogList);

        System.out.println(blogList);
        return "main";

    }

}
