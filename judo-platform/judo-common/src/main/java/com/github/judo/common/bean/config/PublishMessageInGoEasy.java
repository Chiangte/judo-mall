/*
package com.github.judo.common.bean.config;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

*/
/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: GoEasy 消息推送
 * @Date: 2018/11/17 13:37
 * @Version: 1.0
 *//*

@Component
public class PublishMessageInGoEasy {

    @Value("${goeasy.rest_host}")
    private String restHost;

    @Value("${goeasy.common_key}")
    private String commonKey;

    */
/**
     * @param: channel 您的目标channel
     * @param: content 推送的消息内容
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/11/17 13:58
     * @return:
     *//*

    public boolean publish(String channel, String content) {
        GoEasy goEasy = new GoEasy(restHost, commonKey);
        goEasy.publish(channel, content, new PublishListener() {
            @Override
            public void onSuccess() {
                System.out.print("消息发布成功。");
            }

            @Override
            public void onFailed(GoEasyError error) {
                System.out.print("消息发布失败, 错误编码：" + error.getCode() + " 错误信息： " + error.getContent());
            }
        });
        return true;
    }
}
*/
