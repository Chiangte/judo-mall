package com.github.judo.mc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 凌凯短信服务配置
 * @Date: 2018/11/4 14:25
 * @Version: 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sms.lingkai")
public class LingKaiPropertiesConfig {
    /**
     * 短信发送路径
     */
    private String url;

    /**
     * 应用ID
     */
    private String corpId;

    /**
     * 应用秘钥
     */
    private String password;
}
