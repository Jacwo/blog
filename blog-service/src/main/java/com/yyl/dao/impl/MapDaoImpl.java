package com.yyl.dao.impl;

import com.yyl.dao.MapDao;
import com.yyl.mapper.MapMapper;
import com.yyl.model.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-10-24 Time:14:55
 **/
@Repository
public class MapDaoImpl implements MapDao {
    @Autowired
    private MapMapper mapMapper;
    @Override
    public List<Map> getMapList() {
        return mapMapper.getMapList();
    }
}
