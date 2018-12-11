package com.github.judo.common.bean.handler;

import com.github.judo.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 全局的的异常拦截器
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*@Value("${goeasy.enabled}")
    private boolean enabled;*/

    /*@Autowired
    private PublishMessageInGoEasy goEasy;*/

    /**
     * 全局异常.
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public R exception(Exception e) {
        log.info("保存全局异常信息 ex={}", e.getMessage(), e);
        // 出现新Bug时统计数量并推送到前端
        /*if (enabled) {
            goEasy.publish(CommonConstant.channel, "管理员：系统出现新Bug了，请及时查看！");
        }*/
        return new R<>(e);
    }
}
