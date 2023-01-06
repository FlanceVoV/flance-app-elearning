package com.flance.app.elearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(value = {"com.flance.*.*.domain.*.mapper", "com.flance.tenant.biz.common.*.mapper"})
@ComponentScan(value = {"com.flance"})
public class ElearningExamApp {

    public static void main(String[] args) {
        SpringApplication.run(ElearningExamApp.class, args);
    }

}
