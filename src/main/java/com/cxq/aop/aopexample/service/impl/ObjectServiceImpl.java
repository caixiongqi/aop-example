package com.cxq.aop.aopexample.service.impl;

import com.cxq.aop.aopexample.service.ObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ObjectServiceImpl implements ObjectService {

    private static Logger logger = LoggerFactory.getLogger(ObjectServiceImpl.class);

    @Override
    public void objectAspect() {
        logger.info("objectAspect 执行了");
    }
}
