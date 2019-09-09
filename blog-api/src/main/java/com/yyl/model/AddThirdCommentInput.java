package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

/**
 * author:yangyuanliang Date:2019-09-09 Time:16:41
 **/
@Setter
@Getter
public class AddThirdCommentInput {
    private Integer article_id;
    private Integer user_id;
    private Integer comment_id;
    private User to_user;
    private String content;
}
