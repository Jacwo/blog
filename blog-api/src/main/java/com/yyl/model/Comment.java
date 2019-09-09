package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Comment implements Serializable {
    private Integer _id;
    private Integer article_id;
    private String content;
    private boolean is_top;
    private List<OtherComment> other_comments;
    private Integer likes;
    private Integer state;
    private Integer is_handle;
    private Integer user_id;
    private Date create_time;
    private Date update_time;
    private User user;

}
