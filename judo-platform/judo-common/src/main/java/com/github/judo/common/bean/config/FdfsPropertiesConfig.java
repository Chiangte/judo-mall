package com.github.judo.common.bean.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: FastDFs参数
 * @Version: 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "fdfs")
public class FdfsPropertiesConfig {
    private String resHost;
    private String storagePort;

    public String getResHost() {
        return resHost;
    }

    public void setResHost(String resHost) {
        this.resHost = resHost;
    }

    public String getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(String storagePort) {
        this.storagePort = storagePort;
    }
}
