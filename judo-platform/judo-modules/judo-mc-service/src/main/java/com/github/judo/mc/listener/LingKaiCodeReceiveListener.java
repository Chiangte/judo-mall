package com.github.judo.mc.listener;

import com.github.judo.common.constant.MqQueueConstant;
import com.github.judo.common.util.template.LingKaiMsgTemplate;
import com.github.judo.mc.handler.LingKaiMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: lingkai监听短信发送请求
 * @Date: 2018/11/4 14:56
 * @Version: 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = MqQueueConstant.LINGKAI_CODE_QUEUE)
public class LingKaiCodeReceiveListener {
    @Autowired
    private LingKaiMessageHandler lingKaiMessageHandler;

    @RabbitHandler
    public void receive(LingKaiMsgTemplate lingKaiMsgTemplate) {
        long startTime = System.currentTimeMillis();
        log.info("消息中心接收到lingkai发送请求-> 内容：{} ", lingKaiMsgTemplate.getContext());
        lingKaiMessageHandler.sendTelephoneVerify(lingKaiMsgTemplate);
        long useTime = System.currentTimeMillis() - startTime;
        log.info("调用 lingkai网关处理完毕，耗时 {}毫秒", useTime);
    }
}
