package com.dee.basekit.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class AbstractMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时的填充策略
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("createTime") && Objects.isNull(getFieldValByName("createTime", metaObject))) {
            setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }

        if (metaObject.hasSetter("updateTime") && Objects.isNull(getFieldValByName("updateTime", metaObject))) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }

        if (metaObject.hasSetter("createBy") && Objects.isNull(getFieldValByName("createBy", metaObject))) {
            setFieldValByName("createBy", LoginComponent.getUserId(), metaObject);
        }

        if (metaObject.hasSetter("updateBy") && Objects.isNull(getFieldValByName("updateBy", metaObject))) {
            setFieldValByName("updateBy", LoginComponent.getUserId(), metaObject);
        }


    }
   
    /**
     * 更新时的填充策略
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("updateTime") && Objects.isNull(getFieldValByName("updateTime", metaObject))) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }


        if (metaObject.hasSetter("updateBy") && Objects.isNull(getFieldValByName("updateBy", metaObject))) {
            setFieldValByName("updateBy", LoginComponent.getUserId(), metaObject);
        }
    }
}