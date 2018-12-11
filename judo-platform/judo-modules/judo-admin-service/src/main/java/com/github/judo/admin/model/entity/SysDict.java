package com.github.judo.admin.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.github.judo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 字典表
 * @Version: 1.0
 */
@Data
@TableName("sys_dict")
@ToString
@ApiModel("字典表")
public class SysDict extends BaseEntity<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "编号")
    private Integer id;
    /**
     * 数据值
     */
    @ApiModelProperty(value = "数据值", required = true)
    private String value;
    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名", required = true)
    private String label;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = true)
    private String type;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", required = true)
    private String description;
    /**
     * 排序（升序）
     */
    @ApiModelProperty(value = "排序（升序）", required = true)
    private BigDecimal sort;
    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息", required = true)
    private String remarks;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
