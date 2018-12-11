package com.github.judo.ssoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 单点登录客户端
 * @Version: 1.0
 */
@EnableOAuth2Sso
@SpringBootApplication
public class JudoSsoClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoSsoClientDemoApplication.class, args);
    }
}
