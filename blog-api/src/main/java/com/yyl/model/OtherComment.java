package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * author:yangyuanliang Date:2019-09-09 Time:15:59
 **/
@Setter
@Getter
public class OtherComment implements Serializable {
    private User user;
    private User to_user;
    private Integer likes;
    private Integer state;
    private Date create_time;
    private Integer _id;
    private String content;
}
