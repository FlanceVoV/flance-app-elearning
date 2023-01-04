package com.flance.tenant.gateway.common;

import com.flance.web.feign.FeignUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignUserConfig {

    @Bean
    public FeignUser feignUser() {
        FeignUser user = new FeignUser();
        user.setUser("tenant-gateway");
        user.setPass("123456");
        return user;
    }

}

