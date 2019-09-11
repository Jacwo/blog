package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.CategoryService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-11 Time:15:44
 **/
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Reference
    private CategoryService categoryService;
    @RequestMapping("getCategoryList")
    @ResponseBody
    public ResultMap getCategoryList(){
        ResultMap resultMap=new ResultMap();
        List<Category> tags = categoryService.getCategoryList();
        resultMap.setData(tags);
        return resultMap;
    }
}
