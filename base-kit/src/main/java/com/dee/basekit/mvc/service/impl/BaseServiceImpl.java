package com.dee.basekit.mvc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dee.basekit.mvc.domain.BaseDomain;
import com.dee.basekit.mvc.mapper.BaseMapper;
import com.dee.basekit.mvc.service.IBaseService;
import lombok.SneakyThrows;

import java.lang.reflect.ParameterizedType;

public class BaseServiceImpl<T extends BaseDomain, M extends BaseMapper<T>> extends ServiceImpl<M, T> implements IBaseService<T> {
    private final Class<T> tClass;

    private Class<T> gettClass() {
        return tClass;
    }

    @SneakyThrows
    protected T createDomain() {
        return gettClass().getDeclaredConstructor().newInstance();
    }

    @SuppressWarnings("unchecked")
    public BaseServiceImpl() {
        tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
