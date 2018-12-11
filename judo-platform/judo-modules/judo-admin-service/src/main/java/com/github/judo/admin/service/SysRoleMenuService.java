package com.github.judo.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.judo.admin.model.entity.SysRoleMenu;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 角色菜单表 服务类
 * @Version: 1.0
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 更新角色菜单
     *
     * @param role
     * @param roleId  角色
     * @param menuIds 菜单列表
     * @return
     */
    Boolean insertRoleMenus(String role, Integer roleId, String menuIds);
}