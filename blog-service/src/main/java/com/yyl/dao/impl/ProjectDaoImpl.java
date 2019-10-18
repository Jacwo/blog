package com.yyl.dao.impl;

import com.yyl.dao.ProjectDao;
import com.yyl.mapper.ProjectMapper;
import com.yyl.model.Project;
import com.yyl.model.ProjectQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public List<Project> getProjectList(ProjectQuery articleQuery) {
        return projectMapper.projectList(articleQuery);
    }

    @Override
    public Integer getTotalProjectCount() {
        List<Project> totalProjectCount = projectMapper.getTotalProjectCount();
        return totalProjectCount.size();
    }
}
