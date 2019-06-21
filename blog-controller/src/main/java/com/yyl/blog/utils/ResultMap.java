package com.yyl.blog.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultMap<T> {
    private Integer status;
    private Integer code;
    private T data;
    public ResultMap(){
        this.status=200;
        this.code=0;
    }
}
