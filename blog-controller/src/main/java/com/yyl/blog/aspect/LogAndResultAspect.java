package com.yyl.blog.aspect;

import com.yyl.blog.utils.JacksonJsonUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

/**
 * @author yangyuanliang
 * */
@Aspect
@Component
public class LogAndResultAspect {
    private Logger logger = Logger.getLogger(LogAndResultAspect.class);
    @Pointcut("execution(* com.yyl.blog.controller.*.*(..))")
    public void loggerController(){}

    @Around("loggerController()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result = null;
        Object target = joinPoint.getTarget();
        String className = target.getClass().getName();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        StringBuffer argsName = new StringBuffer("(");
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object object : args) {
                if (object == null) {
                    continue;
                }
                // 获取参数的类型
                Class<? extends Object> clazz = object.getClass();
                String argsType = clazz.getName();
                argsName.append(argsType + " " + object + ",");
            }
            if (argsName.length() > 1) {
                argsName = new StringBuffer(argsName.substring(0,argsName.length() - 1));
            }
        }
        argsName.append(")");
        String description = className + "." + methodName + argsName.toString();
        logger.info(String.format("request method:%s", description));
        try {
            result = joinPoint.proceed();
            logger.info(String.format("method (%s) result :%s", description, JacksonJsonUtil.beanToJson(result)));
        } catch (Exception e) {
            logger.error("方法(%s)执行异常:",e);
            throw e;
        }
        return result;
    }
}
