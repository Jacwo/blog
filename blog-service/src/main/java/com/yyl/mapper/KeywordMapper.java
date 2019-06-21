package com.yyl.mapper;


import com.yyl.model.Keyword;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface KeywordMapper {


    @Select("select k.id as _id ,k.name from " +
            "keyword k left join article_keyword ak on k.id=ak.keyword_id where ak.article_id=#{articleId}")
    List<Keyword> getKeywordByArticleID(Integer articleId);
}
