package com.github.judo.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.judo.admin.mapper.SysRoleDeptMapper;
import com.github.judo.admin.model.entity.SysRoleDept;
import com.github.judo.admin.service.SysRoleDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 角色与部门对应关系 服务实现类
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements SysRoleDeptService {

}
