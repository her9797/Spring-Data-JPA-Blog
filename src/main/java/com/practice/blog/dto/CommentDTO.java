package com.practice.blog.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.DateTimeException;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {

    private int commentCode;

    private String commentText;

    private Date date;

    private String cmtId;
}

