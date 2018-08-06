/*
 * EurekaServerApplication.java
 * 2017年7月9日 下午6:39:15
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.api.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.kyle.api.zuul.filter.AccessFilter;

/**
 * 反向代理，，eureka客户端 api网关zuul
 *
 * @version
 * @author kyle 2018年8月6日上午11:06:42
 * @since 1.8
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
@RibbonClient(value = "hello-service-provider")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
