package com.github.judo.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.judo.admin.model.entity.SysDict;
import com.github.judo.admin.service.SysDictService;
import com.github.judo.common.bean.annotation.LoginUser;
import com.github.judo.common.util.Query;
import com.github.judo.common.util.R;
import com.github.judo.common.vo.UserVO;
import com.github.judo.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 字典表 前端控制器
 * @Version: 1.0
 */
@RestController
@RequestMapping("/dict")
@Api(tags = "字典表")
public class DictController extends BaseController {

    @Autowired
    private SysDictService sysDictService;

    /**
     * 通过ID查询字典信息
     *
     * @param id ID
     * @return 字典信息
     */
    @GetMapping("/{id}")
    @ApiOperation("通过ID查询字典信息")
    public SysDict dict(@PathVariable Integer id) {
        return sysDictService.selectById(id);
    }

    /**
     * 分页查询字典信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @RequestMapping("/dictPage")
    @ApiOperation("分页查询字典信息")
    public Page dictPage(@RequestParam Map<String, Object> params, @ApiIgnore @LoginUser UserVO userVO) {
        System.out.println(userVO);
        return sysDictService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 通过字典类型查找字典
     *
     * @param type 类型
     * @return 同类型字典
     */
    @GetMapping("/type/{type}")
    @ApiOperation("通过字典类型查找字典")
    @Cacheable(value = "dict_details", key = "#type")
    public List<SysDict> findDictByType(@PathVariable String type) {
        SysDict condition = new SysDict();
        condition.setType(type);
        return sysDictService.selectList(new EntityWrapper<>(condition));
    }

    /**
     * 添加字典
     *
     * @param sysDict 字典信息
     * @return success、false
     */
    @PostMapping
    @ApiOperation("添加字典")
    @CacheEvict(value = "dict_details", key = "#sysDict.type")
    public R<Boolean> dict(@RequestBody SysDict sysDict) {
        return new R<>(sysDictService.insert(sysDict));
    }

    /**
     * 删除字典，并且清除字典缓存
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}/{type}")
    @ApiOperation("删除字典，并且清除字典缓存")
    @CacheEvict(value = "dict_details", key = "#type")
    public R<Boolean> deleteDict(@PathVariable Integer id, @PathVariable String type) {
        return new R<>(sysDictService.deleteById(id));
    }

    /**
     * 修改字典
     *
     * @param sysDict 字典信息
     * @return success/false
     */
    @PutMapping
    @ApiOperation("修改字典")
    @CacheEvict(value = "dict_details", key = "#sysDict.type")
    public R<Boolean> editDict(@RequestBody SysDict sysDict) {
        return new R<>(sysDictService.updateById(sysDict));
    }
}
