package com.dee.basekit.mvc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dee.basekit.mvc.domain.BaseDomain;

public interface IBaseService<T extends BaseDomain> extends IService<T> {

}
