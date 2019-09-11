package com.yyl.dao.impl;

import com.yyl.dao.CategoryDao;
import com.yyl.dao.TagDao;
import com.yyl.mapper.CategoryMapper;
import com.yyl.mapper.TagMapper;
import com.yyl.model.ArticleCategoryInfo;
import com.yyl.model.Category;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    @Override
    public List<Category> getCategoryByArticleID(Integer article_id) {
        return categoryMapper.getCategoryByArticleID(article_id);
    }

    @Override
    public Category getCategoryByName(String cat) {
        return categoryMapper.getCategoryByName(cat);
    }

    @Override
    public void create(ArticleCategoryInfo articleCategoryInfo) {
        categoryMapper.create(articleCategoryInfo);
    }
}
