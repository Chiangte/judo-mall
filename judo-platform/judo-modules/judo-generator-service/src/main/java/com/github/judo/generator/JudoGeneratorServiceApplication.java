package com.github.judo.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.judo.generator.mapper")
public class JudoGeneratorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoGeneratorServiceApplication.class, args);
    }
}
