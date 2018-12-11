package com.github.judo.fastdfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.github.judo.fastdfs", "com.github.judo.common.bean"})
public class JudoFastdfsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoFastdfsServiceApplication.class, args);
    }
}
