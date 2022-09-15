package com.flance.tenant.gateway.client.fallback;

import com.flance.web.gateway.client.AppClient;
import com.flance.web.gateway.client.fallback.AppClientFallBack;
import org.springframework.cloud.openfeign.FallbackFactory;

public class GatewayAppClientFallBack  extends AppClientFallBack implements FallbackFactory<AppClient> {



}
