package com.practice.blog.dto;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BlogDTO {

    private int blogCode;

    private String title;

    private String content;

    private String blogId;

    private int commentCode;

}
