package com.cxq.aop.aopexample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {

    @Around("within(*..*) && args(a, b)")
    public void around(ProceedingJoinPoint point, String a, String b) throws Throwable {
        String proceed = (String)point.proceed(point.getArgs());
        System.out.println("around的返回值为：" + proceed);
        System.out.println("around的参数a为：" + a);
        System.out.println("around的参数b为：" + b);
    }
}
