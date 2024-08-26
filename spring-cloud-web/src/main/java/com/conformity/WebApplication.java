package com.conformity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guolei
 * @since 2024/7/17 16:56
 */

@SpringBootApplication(scanBasePackages = "com.conformity")
@MapperScan("com.conformity.dal.mapper")
@EnableDiscoveryClient
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
