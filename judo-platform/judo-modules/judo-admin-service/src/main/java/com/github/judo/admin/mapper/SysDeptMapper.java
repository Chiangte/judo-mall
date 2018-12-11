package com.github.judo.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.judo.admin.model.entity.SysDept;

import java.util.List;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 部门管理 Mapper 接口
 * @Version: 1.0
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 关联dept——relation
     *
     * @param delFlag 删除标记
     * @return 数据列表
     */
    List<SysDept> selectDeptDtoList(String delFlag);
}
