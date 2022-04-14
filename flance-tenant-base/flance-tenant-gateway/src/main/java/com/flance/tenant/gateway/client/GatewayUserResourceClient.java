package com.flance.tenant.gateway.client;

import com.flance.tenant.gateway.client.fallback.GatewayUserResourceClientFallBack;
import com.flance.web.gateway.client.UserResourceClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户资源服务接口
 * @author jhf
 */
@FeignClient(name = "flance-auth", contextId = "userResource", path = "/api/user", fallbackFactory = GatewayUserResourceClientFallBack.class)
public interface GatewayUserResourceClient extends UserResourceClient {

}
