package com.github.judo.admin.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.github.judo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 菜单权限表
 * @Version: 1.0
 */
@Data
@TableName("sys_menu")
@ToString
@ApiModel("菜单权限表")
public class SysMenu extends BaseEntity<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.INPUT)
    @ApiModelProperty(value = "菜单ID")
    private Integer menuId;
    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称", required = true)
    private String name;
    /**
     * 菜单权限标识
     */
    @ApiModelProperty(value = "菜单权限标识", required = true)
    private String permission;
    /**
     * 请求链接
     */
    @ApiModelProperty(value = "请求链接", required = true)
    private String url;
    /**
     * 请求方法
     */
    @ApiModelProperty(value = "请求方法", required = true)
    private String method;
    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    @ApiModelProperty(value = "父菜单ID", required = true)
    private Integer parentId;
    /**
     * 图标
     */
    @ApiModelProperty(value = "图标", required = true)
    private String icon;
    /**
     * VUE页面
     */
    @ApiModelProperty(value = "VUE页面", required = true)
    private String component;
    /**
     * 排序值
     */
    @ApiModelProperty(value = "排序值", required = true)
    private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    @ApiModelProperty(value = "菜单类型 （0菜单 1按钮）", required = true)
    private String type;
    /**
     * 前端URL
     */
    @ApiModelProperty(value = "前端URL", required = true)
    private String path;

    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }
}
