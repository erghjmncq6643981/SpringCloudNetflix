/*
 * FeignClientTest.java
 * 2018年6月28日 下午2:33:19
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.client.feign.test;

import com.kyle.client.feign.configuration.OldSystemFeignClientConfiguration;
import com.kyle.client.feign.entity.Person;
import com.kyle.client.feign.oldInter.OldSystemGetFeign;
import com.kyle.client.feign.oldInter.OldSystemPostFeign;

/**
 * 类功能描述
 *
 * @version
 * @author kyle 2018年6月28日下午2:33:19
 * @since 1.8
 */
public class FeignClientTest {
	public static void main(String[] args) {
		OldSystemPostFeign feignPostClient = OldSystemFeignClientConfiguration.remotePostService();
		Person person = new Person();
		person.setName("kyle");
		System.out.println(feignPostClient.postPerson(person).toString());
		OldSystemGetFeign feignGetClient = OldSystemFeignClientConfiguration.remoteGetService();
		System.out.println(feignGetClient.getHost("kyle"));
		System.out.println(feignGetClient.getHost("kyle", "18"));
	}
}
