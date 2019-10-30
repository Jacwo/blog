package com.yyl.blog.timers;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyl.api.MetaService;
import com.yyl.api.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * author:yangyuanliang Date:2019-10-30 Time:11:05
 **/
@Component
public class CachePersistController {
    Logger logger= LoggerFactory.getLogger(CachePersistController.class);
    @Reference
    private RedisService redisService;
    @Reference
    private MetaService metaService;
    @Scheduled(cron = "0 0 0 * * ?")
    public void cachePersist(){
        Set<String> allKeys = redisService.getAllKeys();
        logger.info("开始同步缓存信息");
        for(String key:allKeys){
            String s = redisService.get(key);
            metaService.updateViews(Integer.valueOf(key.split(":")[1]),s);
        }
        logger.info("缓存信息同步完成");
    }
}
