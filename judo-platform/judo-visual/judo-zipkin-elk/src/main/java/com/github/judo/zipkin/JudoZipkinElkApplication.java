package com.github.judo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: zipkin 链路追踪
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class JudoZipkinElkApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoZipkinElkApplication.class, args);
    }
}
