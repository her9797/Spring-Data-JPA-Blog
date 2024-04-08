package com.practice.blog.entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.util.Date;

@Entity(name = "comment")
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "comment_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentCode;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_date")
    private String commentDate;

    @Column(name = "comment_id")
    private String cmtId;

    @ManyToOne
    @JoinColumn(name = "blog_code")
    private Blog blogCode;


    protected Comment() {
    }

    public Comment(int commentCode, String comment, String commentDate, String cmtId, Blog blogCode) {
        this.commentCode = commentCode;
        this.comment = comment;
        this.commentDate = commentDate;
        this.cmtId = cmtId;
        this.blogCode = blogCode;
    }

    public int getCommentCode() {
        return commentCode;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public String getCmtId() {
        return cmtId;
    }

    public Blog getBlogCode() {
        return blogCode;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentCode=" + commentCode +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                ", cmtId='" + cmtId + '\'' +
                ", blogCode=" + blogCode +
                '}';
    }
}
