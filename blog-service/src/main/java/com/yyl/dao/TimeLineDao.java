package com.yyl.dao;

import com.yyl.model.TimeLine;
import com.yyl.model.TimeLineQuery;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-12 Time:11:18
 **/
public interface TimeLineDao {
    List<TimeLine> getTimeLineList(TimeLineQuery tagQuery);
}
