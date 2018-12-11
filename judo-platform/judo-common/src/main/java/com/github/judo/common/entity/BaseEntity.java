package com.github.judo.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 类描述
 * @Version: 1.0
 */
@Getter
@Setter
public abstract class BaseEntity<T extends Model> extends Model<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * 创建人
     */
    @TableField(value = "creater", fill = FieldFill.INSERT)
    protected String creater;

    /*
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected Date createTime;

    /*
     * 最后修改人
     * , strategy = FieldStrategy.NOT_EMPTY
     */
    @TableField(value = "last_modify", fill = FieldFill.INSERT_UPDATE)
    protected String lastModify;

    /*
     * 最后修改时间
     * , strategy = FieldStrategy.NOT_EMPTY
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected Date updateTime;

    /**
     * 0-正常，1-删除
     */
    @TableField("del_flag")
    @TableLogic
    protected String delFlag;
}
