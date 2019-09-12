package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-09-12 Time:11:15
 **/
@Setter
@Getter
public class TimeLineQuery extends BaseQuery implements Serializable {
    private String keyword;

}
