package com.yyl.blog.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultMap<T> {
    private String msg;
    private Integer code;
    private T data;
    public ResultMap(){
        this.code=0;
    }
}
