package com.dee.system.mapper;

import com.dee.system.domain.UserTenantDomain;
import com.dee.system.global.BaseGlobalMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTenantMapper extends BaseGlobalMapper<UserTenantDomain> {

}
