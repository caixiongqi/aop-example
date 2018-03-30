package com.cxq.aop.aopexample.aspect;

import com.cxq.aop.aopexample.annotation.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 注解切面测试
 * @anncation  @within  @target  @args
 */
@Aspect
@Component
public class AnnotationAspect {


    @Pointcut("@annotation(com.cxq.aop.aopexample.annotation.MyLog)")
    public  void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLog annotation = method.getAnnotation(MyLog.class);
        System.out.println("打印："+annotation.value()+" 前置日志");
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLog annotation = method.getAnnotation(MyLog.class);
        System.out.println("打印："+annotation.value()+" 后置日志");
    }


    //匹配方法标注有AdminOnly注解的方法
    //@Pointcut("@annotation(com.aop.demo.security.AdminOnly)")
    public void annoDemo() {
    }

    //匹配标注有Beta的类下的方法，要求annotation的RetentionPplicy级别为CLASS
    //@Pointcut("@within(com.google.common.annotations.Beta)")
    public void annoWithinDemo() {
    }

    //匹配标注有Repository类下的方法，要求的annotation的RetentionPolicy级别为RUNTIME
    //@Pointcut("@target(org.springframework.stereotype.Repository)")
    public void annoTargetDemo() {
    }

    //匹配传入的参数类型标注有Repository注解的方法
    //@Pointcut("@args(org.springframework.stereotype.Repository)")
    public void annoArgsDemo() {
    }

}
