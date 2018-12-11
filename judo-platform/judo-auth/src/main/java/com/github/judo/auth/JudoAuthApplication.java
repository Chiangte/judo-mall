package com.github.judo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 认证服务器, 也是资源服务器
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.github.judo.auth", "com.github.judo.common.bean"})
public class JudoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoAuthApplication.class, args);
    }
}
