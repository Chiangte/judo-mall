package com.github.judo.mc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 消息中心
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JudoMessageCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoMessageCenterApplication.class, args);
    }
}
