package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageData<T> {
    private Integer count;
    private Integer totalArticle;
    private Integer totalLikes;
    private T list;
}
