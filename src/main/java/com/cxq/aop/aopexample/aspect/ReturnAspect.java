package com.cxq.aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ReturnAspect {

    private static Logger logger = LoggerFactory.getLogger(ReturnAspect.class);

    @Pointcut("execution(* com.cxq.aop.aopexample.service..*(..))")
    public void argsPointCut(){}

    @AfterReturning(value = "argsPointCut()", returning = "a")
    public void after(JoinPoint joinPoint, Object a) {
        logger.info("返回值为：{}", a);
        logger.info("返回值joinPoint为：{},{}", joinPoint.getArgs()[0], joinPoint.getArgs()[1]);
    }

    @Before("argsPointCut() && args(a, b)")
    public void before(JoinPoint joinPoint, String a, String b) {
        logger.info("args为：{},{}", a, b);
    }
}
