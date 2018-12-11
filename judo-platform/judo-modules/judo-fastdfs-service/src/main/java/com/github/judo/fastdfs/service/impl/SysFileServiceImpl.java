package com.github.judo.fastdfs.service.impl;

import com.github.judo.fastdfs.model.entity.SysFile;
import com.github.judo.fastdfs.mapper.SysFileMapper;
import com.github.judo.fastdfs.service.SysFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: judo
 * @Description: 公用文件 服务实现类
 * @Date 2018-10-11 21:43:36
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

    @Autowired
    private SysFileMapper sysFileMapper;

}