package com.yyl.api;

import java.util.Set;

/**
 * author:yangyuanliang Date:2019-09-16 Time:14:18
 **/
public interface RedisService {


    Set<String> getAllKeys();
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
