package com.yyl.mapper;


import com.yyl.model.Meta;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface MetaMapper {
    @Select("select id as _id,views,likes,comments from meta where article_id=#{articleId}")
    Meta getTagByArticleID(Integer articleId);
}
