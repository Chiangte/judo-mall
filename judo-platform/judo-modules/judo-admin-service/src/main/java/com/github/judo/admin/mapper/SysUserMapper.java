package com.github.judo.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.judo.admin.model.entity.SysUser;
import com.github.judo.common.bean.interceptor.DataScope;
import com.github.judo.common.util.Query;
import com.github.judo.common.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 用户表 Mapper 接口
 * @Version: 1.0
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 通过用户名查询用户信息（含有角色信息）
     *
     * @param username 用户名
     * @return userVo
     */
    UserVO selectUserVoByUsername(String username);

    /**
     * 分页查询用户信息（含角色）
     *
     * @param query     查询条件
     * @param username  用户名
     * @param dataScope 数据权限
     * @return list
     */
    List selectUserVoPageDataScope(Query query, @Param("username") Object username, DataScope dataScope);

    /**
     * 通过手机号查询用户信息（含有角色信息）
     *
     * @param mobile 用户名
     * @return userVo
     */
    UserVO selectUserVoByMobile(String mobile);

    /**
     * 通过openId查询用户信息
     *
     * @param openId openid
     * @return userVo
     */
    UserVO selectUserVoByOpenId(String openId);

    /**
     * 通过ID查询用户信息
     *
     * @param id 用户ID
     * @return userVo
     */
    UserVO selectUserVoById(Integer id);
}
