package com.yyl.blog.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * author:yangyuanliang Date:2019-12-05 Time:10:20
 **/
public class MsgUtils {
    private static BlockingQueue<String> msgQueue=new LinkedBlockingQueue<>();
    public static void addMsg(String msg){
        msgQueue.add(msg);
    }

    public static String take() throws InterruptedException {
        return msgQueue.take();
    }

}
