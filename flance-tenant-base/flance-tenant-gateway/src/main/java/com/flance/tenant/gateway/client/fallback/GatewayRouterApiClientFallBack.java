package com.flance.tenant.gateway.client.fallback;

import com.flance.web.gateway.client.RouterApiClient;
import com.flance.web.gateway.client.RouterClient;
import com.flance.web.gateway.client.fallback.RouterApiClientFallBack;
import com.flance.web.gateway.client.fallback.RouterClientFallBack;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * routerapi fallback，可以继承
 * @author jhf
 */
public class GatewayRouterApiClientFallBack extends RouterApiClientFallBack implements FallbackFactory<RouterApiClient> {



}
