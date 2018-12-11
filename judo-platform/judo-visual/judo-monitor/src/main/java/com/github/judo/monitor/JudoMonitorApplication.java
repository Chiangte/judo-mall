package com.github.judo.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 监控模块
 * @Version: 1.0
 */
@EnableAdminServer
@EnableTurbine
@EnableDiscoveryClient
@SpringCloudApplication
public class JudoMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoMonitorApplication.class, args);
    }
}
