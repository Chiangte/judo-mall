package com.github.judo.admin.model.dto;

import com.github.judo.admin.model.entity.SysRole;
import lombok.Data;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 角色Dto
 * @Version: 1.0
 */
@Data
public class RoleDTO extends SysRole {
    /**
     * 角色部门Id
     */
    private Integer roleDeptId;

    /**
     * 部门名称
     */
    private String deptName;
}

