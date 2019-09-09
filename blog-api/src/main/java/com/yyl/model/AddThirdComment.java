package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-09-09 Time:15:32
 **/
@Getter
@Setter
public class AddThirdComment implements Serializable {
    private Integer article_id;
    private Integer user_id;
    private Integer comment_id;
    private Integer to_user_id;
    private String content;
}
