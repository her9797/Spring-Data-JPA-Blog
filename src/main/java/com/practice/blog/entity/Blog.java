package com.practice.blog.entity;

import jakarta.persistence.*;

@Entity(name = "blog")
@Table(name = "blog")
public class Blog {

    @Id
    @Column(name = "blog_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogCode;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "blog_id")
    private String blogId;

    @Column(name = "comment_code")
    private int commentCode;

    protected Blog() {
    }

    /** builder() */

    public Blog title(String val){

        this.title = val;
        return this;
    }

    public Blog content(String val) {

        this.content = val;
        return this;
    }

    public Blog blogId(String val) {

        this.blogId = val;
        return this;
    }

    public Blog commentCode(int val){

        this.commentCode = val;
        return this;
    }

    public Blog builder(){
        return new Blog(blogCode, title, content, blogId, commentCode);
    }


    public Blog(int blogCode, String title, String content, String blogId, int commentCode) {
        this.blogCode = blogCode;
        this.title = title;
        this.content = content;
        this.blogId = blogId;
        this.commentCode = commentCode;
    }

    public int getBlogCode() {
        return blogCode;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getBlogId() {
        return blogId;
    }

    public int getCommentCode() {
        return commentCode;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogCode=" + blogCode +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", blogId='" + blogId + '\'' +
                ", commentCode=" + commentCode +
                '}';
    }
}
