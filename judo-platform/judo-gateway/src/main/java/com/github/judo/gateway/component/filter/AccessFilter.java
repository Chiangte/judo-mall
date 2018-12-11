package com.github.judo.gateway.component.filter;

import com.alibaba.fastjson.JSONObject;
import com.github.judo.common.constant.SecurityConstants;
import com.github.judo.common.vo.UserVO;
import com.github.judo.gateway.feign.UserService;
import com.github.judo.gateway.util.RibbonVersionHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 在RateLimitPreFilter 之前执行，不然又空指针问题
 * @Version: 1.0
 */
@Component
public class AccessFilter extends ZuulFilter {

    @Value("${zuul.ribbon.metadata.enabled:false}")
    private boolean canary;

    @Autowired
    private UserService userService;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        String version = ctx.getRequest().getHeader(SecurityConstants.VERSION);
        if (canary && StrUtil.isNotBlank(version)) {
            RibbonVersionHolder.setContext(version);
        }

        ctx.set("startTime", System.currentTimeMillis());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            RequestContext requestContext = RequestContext.getCurrentContext();
            requestContext.addZuulRequestHeader(SecurityConstants.USER_INFO, JSONObject.toJSONString(getUser(authentication.getName())));
            requestContext.addZuulRequestHeader(SecurityConstants.USER_HEADER, authentication.getName());
            requestContext.addZuulRequestHeader(SecurityConstants.ROLE_HEADER, CollectionUtil.join(authentication.getAuthorities(), ","));
        }
        return null;
    }

    public UserVO getUser(String name) {
        return userService.findUserByUsername(name);
    }
}

