package com.flance.tenant.gateway.client.fallback;

import com.flance.web.gateway.client.UserResourceClient;
import com.flance.web.gateway.client.fallback.UserResourceClientFallBack;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * authClient fallback，可以继承
 * @author jhf
 */
public class GatewayUserResourceClientFallBack extends UserResourceClientFallBack implements FallbackFactory<UserResourceClient> {


}