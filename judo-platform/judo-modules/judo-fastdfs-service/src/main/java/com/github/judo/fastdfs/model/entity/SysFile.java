package com.github.judo.fastdfs.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.github.judo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Auther: judo
 * @Description: 公用文件
 * @Date 2018-10-11 21:43:36
 * @Version: 1.0
 */
@Data
@ToString
@TableName("sys_file")
@ApiModel("公用文件")
public class SysFile extends BaseEntity<SysFile> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID 主键 自增长
     */
    @Id
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 文件名
     */
    @TableField(value = "NAME")
    @ApiModelProperty(value = "文件名", required = true)
    private String name;
    /**
     * 文件后缀
     */
    @TableField(value = "suffix")
    @ApiModelProperty(value = "文件后缀", required = true)
    private String suffix;
    /**
     * 文件类型
     */
    @TableField(value = "file_type")
    @ApiModelProperty(value = "文件类型", required = true)
    private String fileType;
    /**
     * 文件大小
     */
    @TableField(value = "size")
    @ApiModelProperty(value = "文件大小", required = true)
    private Long size;
    /**
     * 文件路径
     */
    @TableField(value = "file_path")
    @ApiModelProperty(value = "文件路径", required = true)
    private String filePath;
    /**
     * 业务id
     */
    @TableField(value = "service_id")
    @ApiModelProperty(value = "业务id", required = true)
    private String serviceId;

    public SysFile() {
    }

    public SysFile(String name, String suffix, String fileType, Long size, String filePath, String serviceId) {
        this.name = name;
        this.suffix = suffix;
        this.fileType = fileType;
        this.size = size;
        this.filePath = filePath;
        this.serviceId = serviceId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
