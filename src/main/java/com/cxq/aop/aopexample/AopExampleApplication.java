package com.cxq.aop.aopexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy 开启对spring自定义注解的支持
@EnableAspectJAutoProxy
public class AopExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopExampleApplication.class, args);
	}
}
