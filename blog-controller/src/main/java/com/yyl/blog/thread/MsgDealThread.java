package com.yyl.blog.thread;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.yyl.api.TagService;
import com.yyl.blog.utils.HttpClientUtil;
import com.yyl.blog.utils.MsgUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author:yangyuanliang Date:2019-12-05 Time:10:26
 **/
@Component
public class MsgDealThread implements Runnable{
    private Logger _logger = LoggerFactory.getLogger(MsgDealThread.class);
    @Reference
    private TagService tagService;
    @PostConstruct
    public void init(){
        new Thread(this).start();
    }
    @Override
    public void run() {

        while (true){
            try {
                String msg = MsgUtils.take();
                _logger.debug("收到消息" + msg);
                DealThreadPool.execute(() -> {
                    _logger.debug("开始处理消息" + msg);
                    String address = HttpClientUtil.getAddresses(msg);
                    if(address!=null){
                        JSONObject jsonObject=JSONObject.parseObject(address);
                        String city =(String) jsonObject.get("city");
                        boolean result=tagService.queryByIp(msg);
                        if(!result){
                            tagService.saveIP(msg,city);
                        }

                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
