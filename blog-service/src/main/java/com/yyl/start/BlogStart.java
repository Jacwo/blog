package com.yyl.start;


import com.yyl.conf.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BlogStart {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ServiceConfig.class);
        context.start();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i <beanDefinitionNames.length ; i++) {
            System.out.println(            beanDefinitionNames[i]);
        }
        System.out.println("Provider started.");
        while (true){
            Thread.sleep(Integer.MAX_VALUE);
        }

    }
}
