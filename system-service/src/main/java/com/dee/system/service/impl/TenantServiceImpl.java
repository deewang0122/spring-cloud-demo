package com.dee.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dee.basekit.mvc.result.Result;
import com.dee.basekit.util.ObjectUtils;
import com.dee.system.domain.TenantDomain;
import com.dee.system.domain.UserTenantDomain;
import com.dee.system.enums.StatusEnum;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.mapper.TenantMapper;
import com.dee.system.mapper.UserTenantMapper;
import com.dee.system.param.TenantAddParam;
import com.dee.system.param.TenantEditParam;
import com.dee.system.param.TenantListParam;
import com.dee.system.result.TenantResult;
import com.dee.system.service.ITenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantServiceImpl extends BaseGlobalServiceImpl<TenantDomain, TenantMapper> implements ITenantService {
    @Autowired
    UserTenantMapper userTenantMapper;

    @Override
    public TenantDomain selectByUserId(String userId) {
        LambdaQueryWrapper<UserTenantDomain> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserTenantDomain::getUserId, userId);
        wrapper.eq(UserTenantDomain::getStatus, StatusEnum.DEFAULT.getKey());
        List<UserTenantDomain> userTenantDomainList = userTenantMapper.selectList(wrapper);
        UserTenantDomain userTenantDomain = userTenantDomainList
                .stream()
                .filter(userTenant -> 1 == userTenant.getIsDefault())
                .findFirst()
                .orElse(userTenantDomainList.stream().findFirst().get());
        return getBaseMapper().selectById(userTenantDomain.getTenantId());
    }

    @Override
    public Result save(TenantAddParam param) {
        return null;
    }

    @Override
    public Result update(TenantEditParam param) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public Result<TenantResult> get(String id) {
        return null;
    }

    @Override
    public Result<List<TenantResult>> list(TenantListParam param) {
        List<String> tenantIds = new ArrayList<>();
        if (StringUtils.isEmpty(param.getUserId())) {
            LambdaQueryWrapper<UserTenantDomain> userTenantWrapper = Wrappers.lambdaQuery();
            userTenantWrapper.eq(UserTenantDomain::getUserId, param.getUserId());
            userTenantWrapper.eq(UserTenantDomain::getStatus, StatusEnum.DEFAULT.getKey());
            tenantIds = userTenantMapper.selectList(userTenantWrapper).stream().map(UserTenantDomain::getTenantId).collect(Collectors.toList());
        }
        LambdaQueryWrapper<TenantDomain> tenantWrapper = Wrappers.lambdaQuery();
        tenantWrapper.in(CollectionUtils.isNotEmpty(tenantIds), TenantDomain::getId, tenantIds);
        tenantWrapper.like(StringUtils.isNotEmpty(param.getName()), TenantDomain::getName, param.getName());
        tenantWrapper.orderByAsc(TenantDomain::getSort);
        return Result.success(ObjectUtils.copyObject(getBaseMapper().selectList(tenantWrapper), TenantResult.class));
    }
}
