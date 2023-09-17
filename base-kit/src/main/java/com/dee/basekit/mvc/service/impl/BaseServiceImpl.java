package com.dee.basekit.mvc.service.impl;

import com.dee.basekit.mvc.domain.BaseDomain;
import com.dee.basekit.mvc.service.IBaseService;
import lombok.SneakyThrows;

import java.lang.reflect.ParameterizedType;

public class BaseServiceImpl<T extends BaseDomain> implements IBaseService<T> {
    private Class<T> tClass;

    private Class<T> gettClass() {
        return tClass;
    }

    @SneakyThrows
    protected T instance() {
        return gettClass().getDeclaredConstructor().newInstance();
    }

    @SuppressWarnings("unchecked")
    public BaseServiceImpl() {
        tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
