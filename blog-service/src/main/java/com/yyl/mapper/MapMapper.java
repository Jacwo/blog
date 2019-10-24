package com.yyl.mapper;

import com.yyl.model.Map;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-10-24 Time:14:56
 **/
public interface MapMapper {
    @Select("select `address` as name,`key` as value,`value` as num  from map m " +
            "where m.`address` in (select distinct city from address) ")
    List<Map> getMapList();
}
