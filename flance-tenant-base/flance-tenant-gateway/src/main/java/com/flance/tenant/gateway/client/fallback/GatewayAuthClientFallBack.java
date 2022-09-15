package com.flance.tenant.gateway.client.fallback;

import com.flance.web.gateway.client.AuthClient;
import com.flance.web.gateway.client.fallback.AuthClientFallBack;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * authClient fallback，可以继承
 * @author jhf
 */
public class GatewayAuthClientFallBack extends AuthClientFallBack implements FallbackFactory<AuthClient> {


}