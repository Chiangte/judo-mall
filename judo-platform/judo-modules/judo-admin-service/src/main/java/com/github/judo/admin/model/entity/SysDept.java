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
 * @Description: 部门管理
 * @Version: 1.0
 */
@Data
@TableName("sys_dept")
@ToString
@ApiModel("部门管理")
public class SysDept extends BaseEntity<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dept_id", type = IdType.AUTO)
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称", required = true)
    private String name;
    /**
     * 排序
     */
    @TableField("order_num")
    @ApiModelProperty(value = "排序", required = true)
    private Integer orderNum;

    @TableField("parent_id")
    @ApiModelProperty(value = "parent_id", required = true)
    private Integer parentId;

    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }
}
