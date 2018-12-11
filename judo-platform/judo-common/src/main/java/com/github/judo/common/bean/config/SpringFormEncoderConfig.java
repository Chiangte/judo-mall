package com.github.judo.common.bean.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 解決通过Feign 调用文件服务上次文件时报错
 * @Date: 2018/11/4 18:34
 * @Version: 1.0
 */
@Configuration
public class SpringFormEncoderConfig {
    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder();
    }
}
