package com.github.judo.common.util.exception;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: judo 业务运行时异常
 * @Date: 2018/11/17 14:00
 * @Version: 1.0
 */
public class JudoRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JudoRuntimeException() {
    }

    public JudoRuntimeException(String message) {
        super(message);
    }

    public JudoRuntimeException(Throwable cause) {
        super(cause);
    }

    public JudoRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JudoRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}