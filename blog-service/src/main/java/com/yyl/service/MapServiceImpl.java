package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.MapService;
import com.yyl.api.TagService;
import com.yyl.dao.MapDao;
import com.yyl.dao.TagDao;
import com.yyl.model.Map;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
   private MapDao mapdao;

    @Override
    public List<Map> getMapList() {
        return mapdao.getMapList();
    }
}
