package com.yyl;
import com.yyl.api.RedisService;
import com.yyl.conf.ServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.net.UnknownHostException;
public class BlogServiceStart {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(BlogServiceStart.class);
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ServiceConfig.class);
        context.start();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i <beanDefinitionNames.length ; i++) {
            logger.info("load bean "+beanDefinitionNames[i]);
        }
        RedisService redisService= (RedisService) context.getBean("redisServiceImpl");
        redisService.set("2222","@222222");
        System.out.println(redisService.get("2222"));
        logger.info("blog service started.");
        while (true){
            Thread.sleep(Integer.MAX_VALUE);
        }
    }
}
