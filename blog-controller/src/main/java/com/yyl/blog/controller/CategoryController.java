package com.yyl.blog.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.CategoryService;
import com.yyl.blog.utils.ResultMap;
import com.yyl.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Stack;

/**
 * author:yangyuanliang Date:2019-09-11 Time:15:44
 **/
@Controller
@RequestMapping("/api/category")
public class CategoryController {
    @Reference
    private CategoryService categoryService;
    @RequestMapping("getCategoryList")
    @ResponseBody
    public ResultMap getCategoryList(){
        int a[]=new int[5];

        ResultMap resultMap=new ResultMap();
        List<Category> tags = categoryService.getCategoryList();
        resultMap.setData(tags);
        return resultMap;
    }

    public static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int a[]=new int[nums1.length];
        Stack<Integer> s=new Stack();
        for(int i=nums2.length-1;i>=0;i--){
            s.push(nums2[i]);
        }
        for(int j=0;j<nums1.length;j++){

            while(!s.isEmpty() && nums1[j] >s.peek()){
                s.pop();
            }
            a[j]=s.isEmpty()?-1:s.pop();
            s.clear();
            for(int i=nums2.length-1;i>=j+1;i--){
                s.push(nums2[i]);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int nums1[]={4,1,2};
        int nums2[]={1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }


}
