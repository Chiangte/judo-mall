package com.github.judo.generator.mapper;

import java.util.List;
import java.util.Map;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Date: 2018/9/8 15:48
 * @Description: 代码生成器
 */
public interface GeneratorMapper {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
