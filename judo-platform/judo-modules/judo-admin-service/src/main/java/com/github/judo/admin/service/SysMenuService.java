package com.github.judo.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.judo.admin.model.entity.SysMenu;
import com.github.judo.common.vo.MenuVO;

import java.util.List;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 菜单权限表 服务类
 * @Version: 1.0
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 通过角色名称查询URL 权限
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleName(String role);

    /**
     * 级联删除菜单
     *
     * @param id 菜单ID
     * @return 成功、失败
     */
    Boolean deleteMenu(Integer id);

    /**
     * 更新菜单信息
     *
     * @param sysMenu 菜单信息
     * @return 成功、失败
     */
    Boolean updateMenuById(SysMenu sysMenu);
}
