package com.github.judo.common.util.exception;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 403 授权拒绝
 * @Version: 1.0
 */
public class JudoDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JudoDeniedException() {
    }

    public JudoDeniedException(String message) {
        super(message);
    }

    public JudoDeniedException(Throwable cause) {
        super(cause);
    }

    public JudoDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JudoDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
