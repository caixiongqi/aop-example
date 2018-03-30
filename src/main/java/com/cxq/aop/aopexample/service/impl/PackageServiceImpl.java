package com.cxq.aop.aopexample.service.impl;

import com.cxq.aop.aopexample.service.PackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PackageServiceImpl implements PackageService {

    private static Logger logger = LoggerFactory.getLogger(PackageServiceImpl.class);

    @Override
    public void getPackageTestOne() {
        logger.info("getPackageTestOne 执行了");
    }

    @Override
    public void getPackageTestTwo() {
        logger.info("getPackageTestTwo 执行了");
    }
}
