package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * author:yangyuanliang Date:2019-09-09 Time:16:07
 **/
@Getter
@Setter
public class OtherCommentInfo {
    private Integer user_id;
    private Integer to_user_id;
    private Integer likes;
    private Integer state;
    private Date create_time;
    private Integer _id;
    private String content;
}
