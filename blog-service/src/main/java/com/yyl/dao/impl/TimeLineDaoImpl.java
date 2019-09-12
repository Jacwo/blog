package com.yyl.dao.impl;

import com.yyl.dao.TimeLineDao;
import com.yyl.mapper.TimeLineMapper;
import com.yyl.model.TimeLine;
import com.yyl.model.TimeLineQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-12 Time:11:19
 **/
@Repository
public class TimeLineDaoImpl implements TimeLineDao {
    @Autowired
    private TimeLineMapper timeLineMapper;
    @Override
    public List<TimeLine> getTimeLineList(TimeLineQuery tagQuery) {
        return timeLineMapper.getTimeLineList( tagQuery);
    }
}
