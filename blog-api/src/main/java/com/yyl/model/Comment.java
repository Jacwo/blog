package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {
    private Integer _id;
    private Integer article_id;
    private String content;
    private boolean is_top;
    private Integer likes;
    private Integer state;
    private Integer is_handle;
    private Integer user_id;
    private Date create_time;
    private Date update_time;
    private User user;

}
