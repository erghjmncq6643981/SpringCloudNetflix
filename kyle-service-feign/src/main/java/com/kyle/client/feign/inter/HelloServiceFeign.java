/*
 * HelloServiceFeign.java
 * 2018年6月27日 下午3:32:43
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.client.feign.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyle.client.feign.entity.Person;

/**
 * 类功能描述
 *
 * @version
 * @author kyle 2018年6月27日下午3:32:43
 * @since 1.8
 */
@FeignClient(value = "hello-service-provider")
public interface HelloServiceFeign {

	@RequestMapping(value = "/demo/getHost", method = RequestMethod.GET, produces = "application/json")
	public String getHost(@RequestParam("name") String name);

	@RequestMapping(value = "/demo/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Person postPerson(@RequestParam("name") String name);

	@RequestMapping(value = "/body/postPerson", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public Person postPerson(@RequestBody Person person);

	@RequestMapping(value = "/head/getHost", method = RequestMethod.GET, produces = "application/json")
	public String getHost(@RequestParam("name") String name, @RequestHeader("age") Integer age);
}
