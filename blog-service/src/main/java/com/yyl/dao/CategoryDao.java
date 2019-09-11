package com.yyl.dao;

import com.yyl.model.ArticleCategoryInfo;
import com.yyl.model.Category;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;

import java.util.List;

public interface CategoryDao {
    List<Category>  getCategoryList();
    List<Category> getCategoryByArticleID(Integer article_id);

    Category getCategoryByName(String cat);

    void create(ArticleCategoryInfo articleCategoryInfo);
}
