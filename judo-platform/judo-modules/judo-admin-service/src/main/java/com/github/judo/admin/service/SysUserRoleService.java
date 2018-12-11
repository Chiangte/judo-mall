package com.github.judo.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.judo.admin.model.entity.SysUserRole;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 用户角色表 服务类
 * @Version: 1.0
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return boolean
     * @author 寻欢·李
     * @date 2017年12月7日 16:31:38
     */
    Boolean deleteByUserId(Integer userId);
}
