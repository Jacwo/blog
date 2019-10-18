package com.yyl.api;

import com.yyl.model.Project;
import com.yyl.model.ProjectQuery;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-10-18 Time:10:56
 **/
public interface ProjectService {
    List<Project> getProjectList(ProjectQuery articleQuery);

    Integer getTotalProjectCount();
}
