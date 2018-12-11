package com.github.judo.admin.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 角色菜单表
 * @Version: 1.0
 */
@Data
@TableName("sys_role_menu")
@ToString
@ApiModel("角色菜单表")
public class SysRoleMenu extends Model<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value = "角色ID", required = true)
    private Integer roleId;
    /**
     * 菜单ID
     */
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value = "菜单ID", required = true)
    private Integer menuId;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}
