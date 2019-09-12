package com.yyl.api;
import com.yyl.model.TimeLine;
import com.yyl.model.TimeLineQuery;

import java.util.List;

public interface TimeLineService {
    List<TimeLine> getTimeLineList(TimeLineQuery timeLineQuery);

}
