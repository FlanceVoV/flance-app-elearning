package com.flance.tenant.gateway.client;

import com.flance.tenant.gateway.client.fallback.GatewayRouterClientFallBack;
import com.flance.web.gateway.client.RouterApiClient;
import com.flance.web.utils.web.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "elearning-router", contextId = "router.api", path = "/elearning-router/api", fallbackFactory = GatewayRouterClientFallBack.class)
public interface GatewayRouterApiClient extends RouterApiClient {

    @Override
    @GetMapping("/getApis")
    WebResponse getApis();
}
