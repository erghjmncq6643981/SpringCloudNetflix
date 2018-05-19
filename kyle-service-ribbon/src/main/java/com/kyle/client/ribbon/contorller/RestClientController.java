/*
 * RestClientController.java
 * 2018年5月19日 下午12:03:35
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.client.ribbon.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.client.ribbon.entity.Person;
import com.kyle.client.ribbon.service.ServiceClient;

/**
 * 类功能描述
 *
 * @version
 * @author kyle 2018年5月19日下午12:03:35
 * @since 1.8
 */
@RestController
public class RestClientController {

	@Autowired
	private ServiceClient client;

	/**
	 * @param name
	 * @return Person
	 * @Description: 测试服务提供者post接口
	 * @create date 2018年5月19日上午9:44:08
	 */
	@RequestMapping(value = "/client/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Person postPerson(String name) {
		return client.postPerson(name);
	}

	/**
	 * @param name
	 * @return String
	 * @Description: 测试服务提供者get接口
	 * @create date 2018年5月19日上午9:46:34
	 */
	@RequestMapping(value = "/client/getHost", method = RequestMethod.GET)
	public String getHost(String name) {
		return client.getHost(name);
	}
}
