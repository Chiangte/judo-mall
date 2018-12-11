package com.github.judo.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.judo.common.entity.SysLog;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 日志表 服务类
 * @Version: 1.0
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 通过ID删除日志（逻辑删除）
     *
     * @param id 日志ID
     * @return true/false
     */
    Boolean updateByLogId(Long id);
}
