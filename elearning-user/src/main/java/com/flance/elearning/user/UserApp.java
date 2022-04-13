package com.flance.elearning.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 租户管理服务
 * @author jhf
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(value = {"com.flance.*.*.domain.*.mapper"})
@ComponentScan(value = {"com.flance"})
public class UserApp {

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }

}


