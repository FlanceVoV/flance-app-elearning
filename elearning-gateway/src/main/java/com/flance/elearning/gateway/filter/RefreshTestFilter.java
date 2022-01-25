package com.flance.elearning.gateway.filter;

import com.flance.web.gateway.filter.RefreshCacheFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component(value = "refreshCacheFilter")
public class RefreshTestFilter extends RefreshCacheFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("测试测试测试测试测试");
        return super.filter(exchange, chain);
    }
}
