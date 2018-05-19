/*
 * AutoConfiguration.java
 * 2018年5月19日 上午10:17:34
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.client.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * javaconfig配置一些bean
 *
 * @version
 * @author kyle 2018年5月19日上午10:17:34
 * @since 1.8
 */
@Configuration
public class AutoConfiguration {
	/**
	 * @return RestTemplate
	 * @Description:实现负载均衡
	 * @create date 2018年5月19日上午10:18:05
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * @return IRule
	 * @Description: 具体的负载均衡策略
	 * @create date 2018年5月19日上午10:18:07
	 */
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();// 这里配置策略，和配置文件对应
	}
}
