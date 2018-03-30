package com.cxq.aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 匹配包的切面测试：within
 */
@Aspect
@Component
public class PackageAspect {

    private static Logger logger = LoggerFactory.getLogger(PackageAspect.class);

    //within只能匹配具体的类，不能直接匹配接口
    @Pointcut("within(com.cxq.aop.aopexample.service.impl.PackageServiceImpl)")
    public void packagePointCut() {
    }

    @Before("packagePointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        logger.info("{} 前置通知执行了", method.getName());
    }

    @After("packagePointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        logger.info("{} 后置通知执行了", method.getName());
    }

}
