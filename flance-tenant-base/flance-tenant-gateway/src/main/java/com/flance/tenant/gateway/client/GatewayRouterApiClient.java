package com.flance.tenant.gateway.client;

import com.flance.tenant.gateway.client.fallback.GatewayRouterApiClientFallBack;
import com.flance.web.gateway.client.RouterApiClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "tenant-router", contextId = "router.api", path = "/tenant-router/api", fallbackFactory = GatewayRouterApiClientFallBack.class)
public interface GatewayRouterApiClient extends RouterApiClient {

}
