package com.yyl.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.yyl.api.CategoryService;
import com.yyl.dao.CategoryDao;
import com.yyl.model.Category;
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
