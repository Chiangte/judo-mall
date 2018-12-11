package com.github.judo.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.judo.admin.model.entity.SysRole;
import com.github.judo.common.util.Query;

import java.util.List;
import java.util.Map;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: Mapper 接口
 * @Version: 1.0
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询角色列表含有部门信息
     *
     * @param query     查询对象
     * @param condition 条件
     * @return List
     */
    List<Object> selectRolePage(Query<Object> query, Map<String, Object> condition);

    /**
     * 通过部门ID查询角色列表
     *
     * @param deptId 部门ID
     * @return 角色列表
     */
    List<SysRole> selectListByDeptId(Integer deptId);
}
