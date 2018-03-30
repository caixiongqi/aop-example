package com.cxq.aop.aopexample.service.impl;

import com.cxq.aop.aopexample.service.ReturnAspectService;
import org.springframework.stereotype.Service;

@Service
public class ReturnAspectServiceImpl implements ReturnAspectService {

    @Override
    public String getAspectReturnArgs(String a, String b) {
        return a + b;
    }
}
