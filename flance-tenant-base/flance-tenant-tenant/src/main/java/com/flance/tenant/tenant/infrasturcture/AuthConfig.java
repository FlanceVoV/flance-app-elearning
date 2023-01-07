package com.flance.tenant.tenant.infrasturcture;

import com.flance.web.feign.FeignUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

    @Bean
    public FeignUser feignUser() {
        FeignUser feignUser = new FeignUser();
        feignUser.setUser("user");
        feignUser.setPass("pass");
        return feignUser;
    }

}
