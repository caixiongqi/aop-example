package com.cxq.aop.aopexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *  参数切面匹配
 */
@Aspect
@Component
public class ArgsAspect {

    private static Logger logger = LoggerFactory.getLogger(ArgsAspect.class);

    //过滤出第一个参数是long类型的并且在com.aop.service包下的方法，如果是第一个参数是Long，第二个参数是String则可以写成args(Long,String),如果匹配第一个为Long，其它任意的话则可以写成args(Long, ..)
    @Pointcut("args(String, String) && within(com.cxq.aop.aopexample.service.*.*)")
    public void matchArgs() {
    }

    @Before("matchArgs()")
    public void before() {
        logger.info("测试args=====");
    }
}
