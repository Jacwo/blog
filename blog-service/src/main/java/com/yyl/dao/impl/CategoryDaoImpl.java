package com.yyl.dao.impl;

import com.yyl.dao.CategoryDao;
import com.yyl.dao.TagDao;
import com.yyl.mapper.CategoryMapper;
import com.yyl.mapper.TagMapper;
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
    public List<Category> getCategoryByArticleID(Integer article_id) {
        return categoryMapper.getCategoryByArticleID(article_id);
    }
}
