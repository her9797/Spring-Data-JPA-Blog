package com.practice.blog.controller;

import com.practice.blog.config.SessionData;
import com.practice.blog.dto.BlogDTO;
import com.practice.blog.dto.CommentDTO;
import com.practice.blog.entity.Comment;
import com.practice.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    private final SessionData sessionData;

    public BlogController(BlogService blogService, SessionData sessionData){
        this.blogService = blogService;
        this.sessionData = sessionData;
    }


    /** 상세 조회 */
    @GetMapping("/detail/{blogCode}")
    public String findBlogByCode(@PathVariable int blogCode, Model model){

        BlogDTO blog = blogService.findBlogByBlogCode(blogCode);

        model.addAttribute("blog", blog);


        return "/blog/detail";
    }

    /** 전체 리스트 조회 */
    @GetMapping("/")
    public String findBlogList(Model model){

        List<BlogDTO> blogList = blogService.findBlogList();

        model.addAttribute("blogList", blogList);



        System.out.println(blogList);
        return "main";

    }

    /** 신규 블로그 등록 페이지 오픈 */
    @GetMapping("/blog/insert")
    public void insertPage(){}




    /** 신규 블로그 등록하기 */
    @PostMapping("/blog/insert")
    public String insertNewBlog(BlogDTO blogDTO){

        blogService.insert(blogDTO);

        return "redirect:/";
    }

    /** 블로그 수정 */
    @GetMapping("/blog/modify")
    public void modifyPage() {}

    @PostMapping("/blog/modify")
    public String modifyMenu(BlogDTO blogDTO) {
        blogService.modifyBlog(blogDTO);
        return "redirect:/";
    }

    /** 블로그 삭제 */
    @GetMapping("/blog/delete")
    public void deletePage() {}

    @PostMapping("/blog/delete")
    public String deleteMenu(@RequestParam Integer blogCode) {
        blogService.deleteBlog(blogCode);
        return "redirect:/";
    }

    /** 블로그 검색 */
    @GetMapping("/blog/search")
    public String findByBlog(@RequestParam String title, Model model){

        List<BlogDTO> blogList = blogService.findByBlog(title);

        model.addAttribute("blogList", blogList);
        model.addAttribute("title", title);

        return "/blog/search";


    }


}
