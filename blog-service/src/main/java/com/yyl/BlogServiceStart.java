package com.yyl;
import com.yyl.conf.ServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BlogServiceStart {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(BlogServiceStart.class);
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ServiceConfig.class);
        context.start();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i <beanDefinitionNames.length ; i++) {
            logger.info("load bean "+beanDefinitionNames[i]);
        }
        logger.info("blog service started.");
        while (true){
            Thread.sleep(Integer.MAX_VALUE);
        }
    }
}
