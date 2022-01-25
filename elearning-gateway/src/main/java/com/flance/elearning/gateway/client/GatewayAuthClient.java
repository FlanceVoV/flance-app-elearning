package com.flance.elearning.gateway.client;

import com.flance.elearning.gateway.client.fallback.GatewayAuthClientFallBack;
import com.flance.web.gateway.client.AuthClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "flance-auth", contextId = "permission", path = "/api/permission", fallbackFactory = GatewayAuthClientFallBack.class)
public interface GatewayAuthClient extends AuthClient {

}