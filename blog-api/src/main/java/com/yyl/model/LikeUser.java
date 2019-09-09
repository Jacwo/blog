package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-09-09 Time:14:30
 **/
@Getter
@Setter
public class LikeUser implements Serializable {
    private Integer id;
    private Integer user_id;

}

