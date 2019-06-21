package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Tag implements Serializable {
    private Integer _id;
    private String name;
}
