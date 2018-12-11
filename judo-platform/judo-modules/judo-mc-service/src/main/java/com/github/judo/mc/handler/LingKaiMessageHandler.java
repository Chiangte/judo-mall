package com.github.judo.mc.handler;

import com.github.judo.common.util.Assert;
import com.github.judo.common.util.template.LingKaiMsgTemplate;
import com.github.judo.mc.config.LingKaiPropertiesConfig;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 短信发送工具类
 * @Date: 2018/11/3 13:41
 * @Version: 1.0
 */
@Component
public class LingKaiMessageHandler {

    private static Logger logger = LoggerFactory.getLogger(LingKaiMessageHandler.class);

    @Autowired
    private LingKaiPropertiesConfig lingKaiPropertiesConfig;

    /**
     * 数据校验
     *
     * @param lingKaiMsgTemplate 消息
     */
    public void check(LingKaiMsgTemplate lingKaiMsgTemplate) {
        Assert.isBlank(lingKaiMsgTemplate.getMobile(), "手机号不能为空");
        Assert.isBlank(lingKaiMsgTemplate.getContext(), "验证码不能为空");
    }

    /**
     * 注册短信发送
     *
     * @param lingKaiMsgTemplate
     * @return
     */
    public Integer sendTelephoneVerify(LingKaiMsgTemplate lingKaiMsgTemplate) {
        check(lingKaiMsgTemplate);
        String context = lingKaiMsgTemplate.getContext();
        String send_time = "";
        String send_content = "";
        try {
            send_content = URLEncoder.encode(context.replaceAll("<br/>", " "), "GBK");// 发送内容
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lingKaiPropertiesConfig.getUrl()).append("CorpID=").append(lingKaiPropertiesConfig.getCorpId()).append("&Pwd=").append(lingKaiPropertiesConfig.getPassword()).append("&Mobile=").append(lingKaiMsgTemplate.getMobile()).append("&Content=").append(send_content).append("&Cell=&SendTime=").append(send_time);
        // 发送短信的返回结果
        String result = creteHttpGet(sb.toString());
        if ("error-create-get".equals(result)) {
            result = "0";
        }
        /* 记录短信日志 */
        logger.error("电话号码：{} ; 内容：{} ; 状态码：{}", lingKaiMsgTemplate.getMobile(), context, result);
        /* 记录短信日志 */
        return Integer.parseInt(result);
    }

    /**
     * 修改密码短信提醒
     *
     * @param lingKaiMsgTemplate
     * @return
     */
    public Integer updatePwdPhoneVerify(LingKaiMsgTemplate lingKaiMsgTemplate) {
        check(lingKaiMsgTemplate);
        String send_time = "";
        StringBuilder content = new StringBuilder();
        content.append("【vivo】您正在找回密码，验证码：").append(lingKaiMsgTemplate.getContext()).append("，请在15分钟内按页面提示提交验证码，切勿将验证码泄露于他人！");
        String send_content = "";
        try {
            send_content = URLEncoder.encode(content.toString().replaceAll("<br/>", " "), "GBK");// 发送内容
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lingKaiPropertiesConfig.getUrl()).append("CorpID=").append(lingKaiPropertiesConfig.getCorpId()).append("&Pwd=").append(lingKaiPropertiesConfig.getPassword()).append("&Mobile=").append(lingKaiMsgTemplate.getMobile()).append("&Content=").append(send_content).append("&Cell=&SendTime=").append(send_time);
        // 发送短信的返回结果
        String result = creteHttpGet(sb.toString());
        if ("error-create-get".equals(result)) {
            result = "0";
        }
        /* 记录短信日志 */
        logger.error("电话号码：{} ; 内容：{} ; 状态码：{}", lingKaiMsgTemplate.getMobile(), content.toString(), result);
        /* 记录短信日志 */
        return Integer.parseInt(result);
    }

    /**
     * 发送 Get 请求
     *
     * @param: url
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/11/3 14:00
     * @return: 请求返回内容
     */
    public String creteHttpGet(String url) {
        /* 创建httpclient */
        CloseableHttpClient client = HttpClients.createDefault();
        /* 创建get请求 */
        HttpGet get = new HttpGet(url);
        String result;
        try {
            /* 创建请求响应 */
            CloseableHttpResponse response = client.execute(get);
            /* 获取请求内容 */
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            result = "error-create-get";
        }
        return result;
    }

    /**
     * 发送 Post 请求
     *
     * @param: url
     * @param: map 请求参数
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/11/3 14:00
     * @return: 请求返回内容
     */
    public String createHttpPost(String url, Map<String, String> map) throws Exception {
        /* 创建httpclient */
        CloseableHttpClient client = HttpClients.createDefault();
        /* 创建post */
        HttpPost post = new HttpPost(url);
        /* 创建参数列表 */
        List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> val : map.entrySet()) {
            String name = val.getKey();
            String value = val.getValue();
            NameValuePair pair = new BasicNameValuePair(name, value);
            valuePairs.add(pair);
        }
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairs, "utf-8");
        post.setEntity(urlEncodedFormEntity);
        /* 获取请求响应 */
        CloseableHttpResponse response = client.execute(post);
        /* 获取响应正文内容 */
        HttpEntity entity = response.getEntity();
        /* 将正文内容转化成字符串 */
        String result = EntityUtils.toString(entity);
        return result;
    }

    public static void main(String[] args) {
        //sendTelephoneVerify("18228096986", RandomCodeUtils.getNonce());
        // updatePwdPhoneVerify("18228096986", RandomCodeUtils.getNonce());
    }
}
