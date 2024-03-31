package com.dee.config;

import com.dee.basekit.config.AbstractMetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FillInsertAndUpdateObjectHandler extends AbstractMetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        super.insertFill(metaObject);

        if (metaObject.hasSetter("tenantId") && Objects.isNull(getFieldValByName("tenantId", metaObject))) {
            setFieldValByName("tenantId", "tenantIdtenantId", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        super.updateFill(metaObject);
    }
}
