package com.yyl.mapper;


import com.yyl.model.Category;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CategoryMapper {


    @Select("select c.id as _id ,c.name,c.desc,c.create_time,c.update_time " +
            "from category c left join article_category ac on ac.category_id=c.id " +
            " where ac.article_id=#{article_id}")
    List<Category> getCategoryByArticleID(Integer article_id);
}
