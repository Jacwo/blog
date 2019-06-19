package com.yyl.blog.conf;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.yyl.blog")
@PropertySource("classpath:/blog.properties")
@ComponentScan(value = {"com.yyl.blog"})
public class WebConf {

}
