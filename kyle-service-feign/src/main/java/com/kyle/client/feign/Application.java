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

package com.kyle.client.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

import feign.Logger;

/**
 * 服务调用者，，eureka客户端 feign调用
 *
 * @version
 * @author kyle 2017年7月9日下午6:39:15
 * @since 1.8
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(value = "hello-service-provider")
@EnableFeignClients(basePackages = { "com.kyle.client.feign.inter" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public IRule feignRule() {
		return new ZoneAvoidanceRule();
	}

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
