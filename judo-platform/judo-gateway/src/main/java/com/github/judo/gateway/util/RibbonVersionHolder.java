package com.github.judo.gateway.util;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 类描述
 * @Date: 2018/11/18 13:35
 * @Version: 1.0
 */
public class RibbonVersionHolder {
    private static final ThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static String getContext() {
        return context.get();
    }

    public static void setContext(String value) {
        context.set(value);
    }

    public static void clearContext() {
        context.remove();
    }
}
