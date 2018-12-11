package com.github.judo.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.judo.admin.model.entity.SysMenu;
import com.github.judo.common.vo.MenuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 菜单权限表 Mapper 接口
 * @Version: 1.0
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    List<MenuVO> findMenuByRoleName(@Param("role") String role);
}