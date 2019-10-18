package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.ProjectService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.MessageDto;
import com.yyl.model.PageData;
import com.yyl.model.Project;
import com.yyl.model.ProjectQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-10-18 Time:10:40
 **/
@Controller
@RequestMapping("/api/project")
public class ProjectController {
    @Reference
    private ProjectService projectService;
    @RequestMapping(value = "/getProjectList", method = RequestMethod.GET)
    @ResponseBody
    public ResultMap<List<Project>> getProjectList( ProjectQuery  projectQuery) {
        ResultMap resultMap = new ResultMap();
        projectQuery.setPageNum((projectQuery.getPageNum()-1)*projectQuery.getPageSize());
        PageData pageData=new PageData();
        pageData.setList(projectService.getProjectList(projectQuery));
        pageData.setCount(projectService.getTotalProjectCount());
        resultMap.setData(pageData);
        return resultMap;
    }
}
