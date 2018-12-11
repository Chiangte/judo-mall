package com.github.judo.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.judo.common.entity.SysZuulRoute;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 动态路由配置表 服务类
 * @Version: 1.0
 */
public interface SysZuulRouteService extends IService<SysZuulRoute> {

    /**
     * 立即生效配置
     *
     * @return
     */
    Boolean applyZuulRoute();
}
