package com.cxq.aop.aopexample.aspect;

import com.cxq.aop.aopexample.service.ObjectService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 对象切面测试
 * 对象面测试有三个关键字：this  target  bean
 * 一般用target
 */
@Aspect
@Component
public class ObjectAspect {

    private static Logger logger = LoggerFactory.getLogger(ObjectAspect.class);

    //target(com.cxq.aop.aopexample.service..*) 匹配包下以及子包下的所有类的方法
    @Pointcut("target(com.cxq.aop.aopexample.service.ObjectService)")
    public void objectPointCut(){
    }

    @Before("objectPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        logger.info("{} 对象this测试前置通知执行了", method.getName());
    }
}
