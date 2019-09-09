package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-09-09 Time:15:23
 **/
@Setter
@Getter
public class AddComment implements Serializable {
    private Integer article_id;
    private Integer user_id;
    private String content;
}
