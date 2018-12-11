package com.github.judo.gateway.feign.fallback;

import com.github.judo.common.vo.UserVO;
import com.github.judo.gateway.feign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 类描述
 * @Version: 1.0
 */
@Slf4j
@Service
public class UserServiceFallback implements UserService {
    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @Override
    public UserVO findUserByUsername(String username) {
        log.error("调用{}异常{}", "findUserByUsername", username);
        return null;
    }
}
