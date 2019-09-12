package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.TagService;
import com.yyl.api.TimeLineService;
import com.yyl.dao.TagDao;
import com.yyl.dao.TimeLineDao;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import com.yyl.model.TimeLine;
import com.yyl.model.TimeLineQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TimeLineServiceImpl implements TimeLineService {
    @Autowired
    private TimeLineDao timeLineDao;

    @Override
    public List<TimeLine> getTimeLineList(TimeLineQuery timeLineQuery) {
        return timeLineDao.getTimeLineList(timeLineQuery);
    }
}
