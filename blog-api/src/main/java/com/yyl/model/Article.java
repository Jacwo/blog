package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Article  implements Serializable {
    private Integer _id;
    private String title;
    private String author;
    private String origin;
    private String content;
    private String state;
    private String type;
    private Meta meta;
    private List<String> category;
    private List<String> tags;
    private String desc;
    private String img_url;
    private Date create_time;
}
