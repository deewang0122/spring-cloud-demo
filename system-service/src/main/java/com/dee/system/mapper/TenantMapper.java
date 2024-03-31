package com.dee.system.mapper;

import com.dee.system.domain.TenantDomain;
import com.dee.system.global.BaseGlobalMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TenantMapper extends BaseGlobalMapper<TenantDomain> {

}
