package com.yyl.mapper;

import com.yyl.model.Article;
import com.yyl.model.ArticleDetailDto;
import com.yyl.model.ArticleQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * private String numbers;
 *     private Integer type;
 *     private Integer state;
 *     private Integer origin;
 *     private String author;
 *     private String content;
 **/
public interface ArticleMapper {

    @Select("<script> select id as _id,title,numbers,`desc`,img_url,create_time " +
            "from article where 1=1" +
            "<if test=\"keyword!=null and keyword !=''\"> " +
            "and keyword like %${keyword}%" +
            "</if>" +
            "order by create_time DESC " +
            "LIMIT #{pageNum},#{pageSize}"+
            "</script>")
    List<Article> getArticleList(ArticleQuery articleQuery);
    @Select("select id as _id,title,`desc`,img_url,numbers,type,state,origin,author,content " +
            "from article where id=#{article_id}")
    ArticleDetailDto getArticleById(Integer article_id);
    @Insert("INSERT INTO article (title,`desc`,`type`,numbers,state,origin,content,author,img_url) values" +
            "(#{title},#{desc},#{type},#{numbers},#{state},#{origin},#{content},#{author},#{img_url})")
    @Options(useGeneratedKeys = true, keyProperty = "_id", keyColumn = "id")
    Integer createArticle(Article article);
    @Select("select * from article")
    List<Article> getTotalArticleCount();
}
