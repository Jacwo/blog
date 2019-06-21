package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ArticleDetailDto implements Serializable {
    private Integer _id;
    private String title;
    private Meta meta;
    private List<Tag> tags;
    private List<Category>category;
    private List<String>keyword;
    private List<Comment> comments;
    private String desc;
    private String img_url;
    private String numbers;
    private Integer type;
    private Integer state;
    private Integer origin;
    private String author;
    private String content;
    private Date create_time;
}
