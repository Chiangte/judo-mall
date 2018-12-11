package com.github.judo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 服务中心
 * @Version: 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class JudoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoEurekaApplication.class, args);
    }
}
