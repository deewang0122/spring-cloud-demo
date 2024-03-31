package com.dee.system.mapper;

import com.dee.system.domain.UserDomain;
import com.dee.system.global.BaseGlobalMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseGlobalMapper<UserDomain> {

}
