/*
 * OldSystemFeignClientConfiguration.java
 * 2017年8月28日 下午2:59:49
 * Copyright 2017 Fosun Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Please contact Fosun Corporation or visit
 * www.fosun.com
 * if you need additional information or have any questions.
 * @author kyle
 * @version 1.0
 */

package com.kyle.client.feign.configuration;

import java.io.IOException;

import com.kyle.client.feign.oldInter.OldSystemGetFeign;
import com.kyle.client.feign.oldInter.OldSystemPostFeign;
import com.netflix.client.ClientFactory;
import com.netflix.client.config.IClientConfig;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.LBClient;
import feign.ribbon.LBClientFactory;
import feign.ribbon.RibbonClient;

/**
 * FeignClient创建类
 *
 * @version
 * @author kyle 2017年8月28日下午2:59:49
 * @since 1.8
 */
public class OldSystemFeignClientConfiguration {

	private static void loadProperties() {
		try {
			// 加载配置文件
			ConfigurationManager.loadPropertiesFromResources("feign-client.properties");
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private static IRule zoneAvoidanceRule() {
		return new ZoneAvoidanceRule();
	}

	private static RibbonClient getRibbonClient() {
		loadProperties();
		// 创建附带负载均衡器的RibbonClient
		final RibbonClient client = RibbonClient.builder().lbClientFactory(new LBClientFactory() {
			@Override
			public LBClient create(String clientName) {
				final IClientConfig config = ClientFactory.getNamedConfig(clientName);
				final ILoadBalancer lb = ClientFactory.getNamedLoadBalancer(clientName);
				final ZoneAwareLoadBalancer zb = (ZoneAwareLoadBalancer) lb;
				zb.setRule(zoneAvoidanceRule());
				return LBClient.create(lb, config);
			}
		}).build();
		return client;
	}

	/**
	 * @return OldSystemPostFeign
	 * @Description: 实现ribbon负载均衡，使用Jackson进行编解码
	 * @create date 2018年6月28日下午2:28:56
	 */
	public static OldSystemPostFeign remotePostService() {
		// 封装一个使用Jackson编解码器的FeignClient客户端
		final OldSystemPostFeign computeService = Feign.builder().client(getRibbonClient())
				.encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
				.target(OldSystemPostFeign.class, "http://hello-service-provider/");
		return computeService;
	}

	/**
	 * @return OldSystemGetFeign
	 * @Description: 实现ribbon负载均衡，get请求
	 * @create date 2018年6月28日下午3:11:55
	 */
	public static OldSystemGetFeign remoteGetService() {
		// 封装一个使用Jackson编解码器的FeignClient客户端
		final OldSystemGetFeign computeService = Feign.builder().client(getRibbonClient())
				.target(OldSystemGetFeign.class, "http://hello-service-provider/");
		return computeService;
	}

}
