package com.dee.system.mapper;

import com.dee.system.domain.AccountDomain;
import com.dee.system.global.BaseGlobalMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseGlobalMapper<AccountDomain> {
}
