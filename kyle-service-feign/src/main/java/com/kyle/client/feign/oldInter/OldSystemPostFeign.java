/*
 * OldSystemFeign.java
 * 2018年6月28日 下午2:05:39
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.client.feign.oldInter;

import com.kyle.client.feign.entity.Person;

import feign.Headers;
import feign.RequestLine;

/**
 * 非Spring Boot工程使用feign组件,post请求
 *
 * @version
 * @author kyle 2018年6月28日下午2:05:39
 * @since 1.8
 */
public interface OldSystemPostFeign {

	/**
	 * @param person
	 * @return Person
	 * @Description:
	 * @create date 2018年6月28日下午2:08:56
	 */
	@RequestLine("POST /body/postPerson") // post 提交
	@Headers({ "Content-Type: application/json; charset=UTF-8", "Accept: application/json; charset=UTF-8" })
	public Person postPerson(Person person);

}
