package com.flance.tenant.gateway.client;

import com.flance.tenant.gateway.client.fallback.GatewayRouterClientFallBack;
import com.flance.web.gateway.client.RouterClient;
import com.flance.web.utils.web.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tenant-router", contextId = "router.router", path = "/tenant-router/router", fallbackFactory = GatewayRouterClientFallBack.class)
public interface GatewayRouterClient extends RouterClient {

    @Override
    @GetMapping("/getRouters")
    WebResponse getRouters();

}
