package com.github.judo.common.vo;

import com.github.judo.common.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 类描述
 * @Version: 1.0
 */
@Data
public class LogVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private SysLog sysLog;
    private String username;
}