package com.flance.elearning.gateway.client.fallback;

import com.flance.web.gateway.client.AppClient;
import com.flance.web.gateway.client.fallback.AppClientFallBack;
import feign.hystrix.FallbackFactory;

public class GatewayAppClientFallBack  extends AppClientFallBack implements FallbackFactory<AppClient> {



}
