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

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "comment_date")
    private Date date;

    @Column(name = "comment_id")
    private String cmtId;



    protected Comment() {
    }

    public Comment(int commentCode, String commentText, Date date, String cmtId) {
        this.commentCode = commentCode;
        this.commentText = commentText;
        this.date = date;
        this.cmtId = cmtId;
    }

    public int getCommentCode() {
        return commentCode;
    }

    public String getCommentText() {
        return commentText;
    }

    public Date getDate() {
        return date;
    }

    public String getCmtId() {
        return cmtId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentCode=" + commentCode +
                ", comment='" + commentText + '\'' +
                ", date=" + date +
                ", cmtId='" + cmtId + '\'' +
                '}';
    }
}
