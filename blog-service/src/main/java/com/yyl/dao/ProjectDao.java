package com.yyl.dao;

import com.yyl.model.*;

import java.util.List;


public interface ProjectDao {
    List<Project> getProjectList(ProjectQuery articleQuery);

    Integer getTotalProjectCount();
}
