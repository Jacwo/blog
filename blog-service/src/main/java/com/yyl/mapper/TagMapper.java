package com.yyl.mapper;


import com.yyl.model.ArticleTagInfo;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select t.id as _id ,t.name from tag t left join article_tag at on at.tag_id=t.id " +
            "where at.article_id=#{articleId}")
    List<Tag> getTagByArticleID(Integer articleId);
    @Select("select t.id as _id ,t.name from tag t where t.name=#{name}")
    Tag getTagByName(String name);
    @Insert("insert into article_tag(tag_id,article_id) values(#{tagId},#{articleId})")
    void create(ArticleTagInfo articleTagInfo);
}
