/*
 * RestServiceProvider.java
 * 2018年5月19日 上午9:32:19
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.service.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.service.provider.entity.Person;

/**
 * restful风格的接口
 *
 * @version
 * @author kyle 2018年5月19日上午9:32:19
 * @since 1.8
 */
@RestController
public class RestServiceProvider {
	@Value("${server.port}")
	private String port;
	@Value("${spring.cloud.client.ipAddress}")
	private String ipAddress;

	/**
	 * @param name
	 * @return Person
	 * @Description: post接口
	 * @create date 2018年5月19日上午9:44:08
	 */
	@RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Person postPerson(@RequestParam("name") String name) {
		Person person = new Person();
		person.setName(name);
		person.setAge("10");
		person.setSex("man");
		return person;
	}

	/**
	 * @param person
	 * @return Person
	 * @Description: post接口
	 * @create date 2018年6月27日下午5:50:56
	 */
	@RequestMapping(value = "/body/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Person postPerson(@RequestBody Person person) {
		person.setAge("10");
		person.setSex("man");
		return person;
	}

	/**
	 * @param name
	 * @return String
	 * @Description: get接口
	 * @create date 2018年5月19日上午9:46:34
	 */
	@RequestMapping(value = "/demo/getHost", method = RequestMethod.GET)
	public String getHost(@RequestParam("name") String name) {
		return "hi, " + name + "! i from " + ipAddress + ":" + port;
	}

	/**
	 * @param name
	 * @param age
	 * @return String
	 * @Description: get接口,包含header信息
	 * @create date 2018年6月27日下午5:43:29
	 */
	@RequestMapping(value = "/head/getHost", method = RequestMethod.GET)
	public String getHost(@RequestParam("name") String name, @RequestHeader Integer age) {
		return "hi, " + name + ", your age is " + age + "! i from " + ipAddress + ":" + port;
	}
}
