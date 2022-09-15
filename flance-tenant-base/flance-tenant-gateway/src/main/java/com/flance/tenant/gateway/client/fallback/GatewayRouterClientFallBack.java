package com.flance.tenant.gateway.client.fallback;

import com.flance.web.gateway.client.RouterClient;
import com.flance.web.gateway.client.fallback.RouterClientFallBack;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * router fallback，可以继承
 * @author jhf
 */
public class GatewayRouterClientFallBack extends RouterClientFallBack implements FallbackFactory<RouterClient> {



}
