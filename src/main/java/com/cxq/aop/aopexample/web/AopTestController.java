package com.cxq.aop.aopexample.web;

import com.cxq.aop.aopexample.annotation.MyLog;
import com.cxq.aop.aopexample.aspect.ObjectAspect;
import com.cxq.aop.aopexample.service.ObjectService;
import com.cxq.aop.aopexample.service.PackageService;
import com.cxq.aop.aopexample.service.ReturnAspectService;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "aop")
public class AopTestController{

    private static Logger logger = LoggerFactory.getLogger(AopTestController.class);

    @Autowired
    private PackageService packageService;

    @Autowired
    private ObjectService objectService;

    @Autowired
    private ReturnAspectService returnAspectService;

    @RequestMapping(value = "/annotation/test")
    @MyLog
    public String getLog() {
        logger.info("当前时间为：{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "当前时间为：" + new Date();
    }

    @RequestMapping(value = "/package/test")
    public String testPackageAspect() {
        packageService.getPackageTestOne();
        packageService.getPackageTestTwo();
        logger.info("当前时间为：{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "当前时间为：" + new Date();
    }

    @RequestMapping(value = "/object/test")
    public String testObjectAspect() {
        objectService.objectAspect();
        return "当前时间为：" + new Date();
    }

    @RequestMapping(value = "/args/test")
    public String testArgsAspect() {
        returnAspectService.getAspectReturnArgs("hello"," world");
        return "当前时间为：" + new Date();
    }
}
