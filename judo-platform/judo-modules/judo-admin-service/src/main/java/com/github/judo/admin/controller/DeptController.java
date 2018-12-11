package com.github.judo.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.judo.admin.model.dto.DeptTree;
import com.github.judo.admin.model.entity.SysDept;
import com.github.judo.admin.service.SysDeptService;
import com.github.judo.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 部门管理 前端控制器
 * @Version: 1.0
 */
@RestController
@RequestMapping("/dept")
@Api(tags = "部门管理")
public class DeptController extends BaseController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysDept
     */
    @GetMapping("/{id}")
    @ApiOperation("通过ID查询")
    public SysDept get(@PathVariable Integer id) {
        return sysDeptService.selectById(id);
    }

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @GetMapping(value = "/tree")
    @ApiOperation("返回树形菜单集合")
    public List<DeptTree> getTree() {
        SysDept condition = new SysDept();
        return sysDeptService.selectListTree(new EntityWrapper<>(condition));
    }

    /**
     * 添加
     *
     * @param sysDept 实体
     * @return success/false
     */
    @PostMapping
    @ApiOperation("添加")
    public Boolean add(@RequestBody SysDept sysDept) {
        return sysDeptService.insertDept(sysDept);
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public Boolean delete(@PathVariable Integer id) {
        return sysDeptService.deleteDeptById(id);
    }

    /**
     * 编辑
     *
     * @param sysDept 实体
     * @return success/false
     */
    @PutMapping
    @ApiOperation("编辑")
    public Boolean edit(@RequestBody SysDept sysDept) {
        return sysDeptService.updateDeptById(sysDept);
    }
}
