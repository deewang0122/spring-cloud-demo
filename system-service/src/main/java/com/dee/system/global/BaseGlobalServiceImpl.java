package com.dee.system.global;

import com.dee.basekit.mvc.service.impl.BaseServiceImpl;

public abstract class BaseGlobalServiceImpl<T extends BaseGlobalDomain, M extends BaseGlobalMapper<T>> extends BaseServiceImpl<T, M> implements BaseGlobalService<T> {

}
