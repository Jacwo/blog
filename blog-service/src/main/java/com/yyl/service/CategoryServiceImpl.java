package com.yyl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.CategoryService;
import com.yyl.api.TagService;
import com.yyl.dao.CategoryDao;
import com.yyl.dao.TagDao;
import com.yyl.model.Category;
import com.yyl.model.Tag;
import com.yyl.model.TagQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
