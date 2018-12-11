package com.github.judo.common.constant.enums;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 类描述
 * @Version: 1.0
 */
public enum CommonEntityField {
    CREATER("creater"),
    CREATETIME("createTime"),
    LASTMODIFY("lastModify"),
    UPDATETIME("updateTime"),
    DELFLAG("delFlag");

    private String value;

    private CommonEntityField(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
