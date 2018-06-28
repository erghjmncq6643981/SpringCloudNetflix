/*
 * ServiceClient.java
 * 2018年5月19日 上午10:44:16
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.client.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kyle.client.ribbon.entity.Person;

/**
 * 类功能描述
 *
 * @version
 * @author kyle 2018年5月19日上午10:44:16
 * @since 1.8
 */
@Service
public class ServiceClient {
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @param name
	 * @return String
	 * @Description:
	 * @create date 2018年5月19日下午12:08:29
	 */
	public String getHost(String name) {
		return restTemplate.getForObject("http://hello-service-provider/demo/getHost?name=" + name, String.class);
	}

	/**
	 * @param name
	 * @return Person
	 * @Description:
	 * @create date 2018年5月19日下午12:08:43
	 */
	public Person postPerson(String name) {
		return restTemplate.postForObject("http://hello-service-provider/demo/postPerson?name=" + name, null,
				Person.class);
	}
}
