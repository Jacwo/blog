package com.yyl.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-10-24 Time:14:51
 **/
@Getter
@Setter
public class Map  implements Serializable {
    private String name;
    private String value;
    private String num;
}
