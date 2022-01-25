package com.flance.elearning.gateway.client.fallback;

import com.flance.web.gateway.client.RouterClient;
import com.flance.web.gateway.client.fallback.RouterClientFallBack;
import feign.hystrix.FallbackFactory;

/**
 * router fallback，可以继承
 * @author jhf
 */
public class GatewayRouterClientFallBack extends RouterClientFallBack implements FallbackFactory<RouterClient> {



}
