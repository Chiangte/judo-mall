package com.github.judo.common.util.template;

import lombok.Data;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: lingkai短信消息模板
 * @Date: 2018/11/4 15:08
 * @Version: 1.0
 */
@Data
public class LingKaiMsgTemplate {
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 组装后的模板内容JSON字符串
     */
    private String context;

    public LingKaiMsgTemplate(String mobile, String context) {
        this.mobile = mobile;
        this.context = context;
    }
}
