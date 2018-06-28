/*
 * OldSystemGetFeign.java
 * 2018年6月28日 下午3:06:34
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

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 非Spring Boot工程使用feign组件,get请求
 *
 * @version
 * @author kyle 2018年6月28日下午3:06:34
 * @since 1.8
 */
public interface OldSystemGetFeign {
	/**
	 * @param name
	 * @return String
	 * @Description:
	 * @create date 2018年6月28日下午2:08:43
	 */
	@RequestLine("GET /demo/getHost?name={name}")
	public String getHost(@Param("name") String name);

	/**
	 * @param name
	 * @param age
	 * @return String
	 * @Description:
	 * @create date 2018年6月28日下午2:14:38
	 */
	@RequestLine("GET /head/getHost?name={name}")
	@Headers({ "age: {age}" })
	public String getHost(@Param("name") String name, @Param("age") String age);
}
