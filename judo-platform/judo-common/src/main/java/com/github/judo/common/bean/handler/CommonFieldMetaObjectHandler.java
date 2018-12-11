package com.github.judo.common.bean.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.github.judo.common.constant.enums.CommonEntityField;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 定义填充公共字段 ,即没有传的字段自动填充
 * @Version: 1.0
 */
@Component
public class CommonFieldMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object creater = getFieldValByName(CommonEntityField.CREATER.getValue(), metaObject);
        Object createTime = getFieldValByName(CommonEntityField.CREATETIME.getValue(), metaObject);
        Object lastModify = getFieldValByName(CommonEntityField.LASTMODIFY.getValue(), metaObject);
        Object updateTime = getFieldValByName(CommonEntityField.UPDATETIME.getValue(), metaObject);
        Object delFlag = getFieldValByName(CommonEntityField.DELFLAG.getValue(), metaObject);

        if (creater == null) {
            setFieldValByName(CommonEntityField.CREATER.getValue(), "1", metaObject);
        }

        if (createTime == null) {
            setFieldValByName(CommonEntityField.CREATETIME.getValue(), new Timestamp(System.currentTimeMillis()), metaObject);
        }

        if (lastModify == null) {
            setFieldValByName(CommonEntityField.LASTMODIFY.getValue(), "1", metaObject);
        }

        if (updateTime == null) {
            setFieldValByName(CommonEntityField.UPDATETIME.getValue(), new Timestamp(System.currentTimeMillis()), metaObject);
        }

        if (delFlag == null) {
            setFieldValByName(CommonEntityField.DELFLAG.getValue(), "0", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(CommonEntityField.LASTMODIFY.getValue(), "1", metaObject);

        setFieldValByName(CommonEntityField.UPDATETIME.getValue(), new Timestamp(System.currentTimeMillis()), metaObject);
    }

    public String getCurrentUsername() {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {

            Object principal = authentication.getPrincipal();

            if (principal != null) {
                if (principal instanceof UserDetails) {
                    return ((UserDetails) principal).getUsername();
                }

                if (principal instanceof Principal) {
                    return ((Principal) principal).getName();
                }
            }
        }*/

        return null;
    }
}