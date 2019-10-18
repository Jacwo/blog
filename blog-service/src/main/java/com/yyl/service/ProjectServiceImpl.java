package com.yyl.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.ProjectService;
import com.yyl.dao.ProjectDao;
import com.yyl.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Override
    public List<Project> getProjectList(ProjectQuery projectQuery) {
        return projectDao.getProjectList(projectQuery);
    }

    @Override
    public Integer getTotalProjectCount() {
        return projectDao.getTotalProjectCount();
    }
}
