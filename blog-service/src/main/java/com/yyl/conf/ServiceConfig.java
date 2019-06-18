package com.yyl.conf;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.yyl.service")
@PropertySource("classpath:/dubbo.properties")
public class ServiceConfig {

}
