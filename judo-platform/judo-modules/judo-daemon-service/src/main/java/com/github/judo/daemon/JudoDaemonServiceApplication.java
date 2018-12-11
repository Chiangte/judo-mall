package com.github.judo.daemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 分布式任务调度模块
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JudoDaemonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoDaemonServiceApplication.class, args);
    }
}
