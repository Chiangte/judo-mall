package com.github.judo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 分布式配置中心
 * @Version: 1.0
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class JudoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoConfigApplication.class, args);
    }
}
