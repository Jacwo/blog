package com.yyl.mapper;


import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface TagMapper {

    @Select("<script> select id as _id,name " +
            "from tag where 1=1" +
            "<if test=\"keyword!=null and keyword !=''\"> " +
            "and keyword like %${keyword}%" +
            "</if>" +
            "LIMIT #{pageNum},#{pageSize}"+
            "</script>")
    List<Tag> getTagList(TagQuery tagQuery);

    @Select("select id as _id ,name from tag where article_id=#{articleId}")
    List<Tag> getTagByArticleID(Integer articleId);
}
