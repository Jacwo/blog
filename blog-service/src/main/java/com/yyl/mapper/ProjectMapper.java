package com.yyl.mapper;

import com.yyl.model.Article;
import com.yyl.model.Project;
import com.yyl.model.ProjectQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ProjectMapper {

    @Select("<script> select id as _id,title,url,content,img,start_time,end_time " +
            "from project where 1=1" +
            "<if test=\"keyword!=null and keyword !=''\"> " +
            "and keyword like %${keyword}%" +
            "</if>" +
            "LIMIT #{pageNum},#{pageSize}"+
            "</script>")
    List<Project> projectList(ProjectQuery projectQuery);
    @Select("select * from project")
    List<Project> getTotalProjectCount();
}
