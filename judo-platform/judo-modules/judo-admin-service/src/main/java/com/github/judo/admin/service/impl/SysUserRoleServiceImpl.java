package com.github.judo.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.judo.admin.mapper.SysUserRoleMapper;
import com.github.judo.admin.model.entity.SysUserRole;
import com.github.judo.admin.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 用户角色表 服务实现类
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    @Override
    @Transactional
    public Boolean deleteByUserId(Integer userId) {
        return baseMapper.deleteByUserId(userId);
    }
}

