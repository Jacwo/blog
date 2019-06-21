package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TagQuery extends BaseQuery implements Serializable {
    private String keyword;

}
