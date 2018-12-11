package com.github.judo.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.judo.admin.mapper.SysLogMapper;
import com.github.judo.admin.service.SysLogService;
import com.github.judo.common.entity.SysLog;
import com.github.judo.common.util.Assert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 日志表 服务实现类
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    @Transactional
    public Boolean updateByLogId(Long id) {
        Assert.isNull(id, "日志ID为空");

        SysLog sysLog = new SysLog();
        sysLog.setId(id);
        return deleteById(sysLog);
    }
}
