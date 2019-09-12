package com.yyl.mapper;

import com.yyl.model.TimeLine;
import com.yyl.model.TimeLineQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-12 Time:11:20
 **/
public interface TimeLineMapper {
    @Select("select t.id as _id ,t.state,t.title,t.content,t.start_time as startTime,t.end_time as endTime from time_line t ")
    List<TimeLine> getTimeLineList(TimeLineQuery tagQuery);
}
