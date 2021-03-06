package com.flance.tenant.gateway.client;

import com.flance.tenant.gateway.client.fallback.GatewayAppClientFallBack;
import com.flance.web.gateway.client.AppClient;
import com.flance.web.utils.web.response.WebResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tenant-router", contextId = "router.app", path = "/tenant-router/app", fallbackFactory = GatewayAppClientFallBack.class)
public interface GatewayAppClient extends AppClient {

    @Override
    @GetMapping("/getApps")
    WebResponse getApps();

}
