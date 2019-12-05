package com.yyl.blog.thread;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author:yangyuanliang Date:2019-12-05 Time:10:46
 **/
@Component
public class DealThreadPool {
    private static ThreadPoolExecutor threadPoolExecutor;
    @PostConstruct
    public void init(){
        threadPoolExecutor=new ThreadPoolExecutor(20,100,200, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
    }

    public static void execute(Runnable runable){
        if (runable != null) {
            threadPoolExecutor.execute(runable);
        }
    }

}
