package com.github.judo.admin.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.judo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 用户表
 * @Version: 1.0
 */
@Data
@TableName("sys_user")
@ToString
@ApiModel("用户表")
public class SysUser extends BaseEntity<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private Integer userId;

    /**
     * 用户名
     */
    private String username;
    @ApiModelProperty(value = "用户名", required = true)
    private String password;

    /**
     * 随机盐
     */
    @JsonIgnore
    @ApiModelProperty(value = "随机盐", required = true)
    private String salt;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介", required = true)
    private String phone;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像", required = true)
    private String avatar;

    /**
     * 部门ID
     */
    @TableField("dept_id")
    @ApiModelProperty(value = "部门ID", required = true)
    private Integer deptId;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
