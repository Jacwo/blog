package com.yyl.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
public class Article  implements Serializable {
    private Integer _id;
    private String title;
    private String author;
    private String origin;
    private String content;
    private String numbers;
    private String state;
    private String type;
    private Meta meta;
    private List<String> category;
    private List<String> tags;
    private String desc;
    private String img_url;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date create_time;
}
