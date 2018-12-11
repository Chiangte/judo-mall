package com.github.judo.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.judo.admin.mapper.SysMenuMapper;
import com.github.judo.admin.model.entity.SysMenu;
import com.github.judo.admin.service.SysMenuService;
import com.github.judo.common.util.Assert;
import com.github.judo.common.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 菜单权限表 服务实现类
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    @Cacheable(value = "menu_details", key = "#role  + '_menu'")
    public List<MenuVO> findMenuByRoleName(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }

    @Override
    @CacheEvict(value = "menu_details", allEntries = true)
    @Transactional
    public Boolean deleteMenu(Integer id) {
        Assert.isNull(id, "菜单ID不能为空");
        // 删除当前节点
        SysMenu condition1 = new SysMenu();
        condition1.setMenuId(id);
        this.deleteById(condition1);

        // 删除父节点为当前节点的节点
        SysMenu sysMenu = new SysMenu();
        sysMenu.setParentId(id);
        return this.deleteById(sysMenu);
    }

    @Override
    @CacheEvict(value = "menu_details", allEntries = true)
    @Transactional
    public Boolean updateMenuById(SysMenu sysMenu) {
        return this.updateById(sysMenu);
    }
}
