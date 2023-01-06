package com.flance.app.elearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(value = {"com.flance.*.*.domain.*.service"})
@ComponentScan(value = {"com.flance"})
public class ElearningTenantApp {
}
