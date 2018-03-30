package com.cxq.aop.aopexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *   execution(
 * //权限修饰符（如public、private）
 * [modifier-pattern],
 * //返回值（如*表示任意返回值，void表示无返回值）
 * ret-type-pattern,
 * //包名（如com.aop.service.*Service.*(..)表示对应包com.hhu.service中以Service结尾的类中的任意方法（该方法可以带任意参数），如果匹配无参的则可以写成（），如果像拦截产生异常的方法，则可以写成(..) throws+具体异常 ）
 * [declaring-type-pattern],
 * name-pattern(或者是param-pattern)，
 * [throws-pattern]
 * )
 */
@Aspect
@Component
public class ExecutionAspect {
    @Pointcut("execution(* *..*(..)) && within(com.cxq..*) ") //说明 权限修饰符可以省略
    public void annotationPointCut(){}

    // ..代表*.*.*多级目录，比如包在com.cxq.aop.service.impl下， 包下的所有方法可以表示为*..*(..)

    @Before("annotationPointCut()")
    public void before() {
        System.out.println("xxx");
    }

}
