package com.hanboard.educloud.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 程序入口
 *
 * @author NiBo
 */

@SpringBootApplication
@EnableDiscoveryClient  // 启用 Eureka
@EnableCircuitBreaker // 启用 Hystrix
@EnableFeignClients // 启用 Feign
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
