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
 * @Description: 用户角色表
 * @Version: 1.0
 */
@Data
@TableName("sys_user_role")
@ToString
@ApiModel("用户角色表")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value = "用户ID", required = true)
    private Integer userId;
    /**
     * 角色ID
     */
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value = "角色ID", required = true)
    private Integer roleId;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
