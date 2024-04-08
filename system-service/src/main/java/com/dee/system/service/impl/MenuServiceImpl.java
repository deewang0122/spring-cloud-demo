package com.dee.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dee.basekit.mvc.result.Result;
import com.dee.basekit.util.ObjectUtils;
import com.dee.system.domain.MenuDomain;
import com.dee.system.domain.RoleMenuDomain;
import com.dee.system.domain.RoleRelationDomain;
import com.dee.system.enums.RoleRelationEnum;
import com.dee.system.enums.StatusEnum;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.mapper.MenuMapper;
import com.dee.system.mapper.RoleMenuMapper;
import com.dee.system.mapper.RoleRelationMapper;
import com.dee.system.param.MenuAddParam;
import com.dee.system.param.MenuEditParam;
import com.dee.system.param.MenuListPageParam;
import com.dee.system.result.MenuListTreeResult;
import com.dee.system.result.MenuResult;
import com.dee.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseGlobalServiceImpl<MenuDomain, MenuMapper> implements IMenuService {
    @Autowired
    RoleRelationMapper roleRelationMapper;
    @Autowired
    RoleMenuMapper roleMenuMapper;


    @Override
    public Result save(MenuAddParam param) {
        return null;
    }

    @Override
    public Result update(MenuEditParam param) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public Result<MenuResult> get(String id) {
        return null;
    }

    @Override
    public Result<MenuResult> listPage(MenuListPageParam param) {
        return null;
    }

    @Override
    public Result<List<MenuListTreeResult>> listTree(String tenantId, String userId) {
        LambdaQueryWrapper<RoleRelationDomain> userWrapper = Wrappers.lambdaQuery();
        userWrapper.eq(RoleRelationDomain::getRelationId, userId);
        userWrapper.eq(RoleRelationDomain::getType, RoleRelationEnum.TYPE_USER.getKey());
        userWrapper.eq(RoleRelationDomain::getStatus, StatusEnum.DEFAULT.getKey());
        List<RoleRelationDomain> userMenuList = roleRelationMapper.selectList(userWrapper);

        LambdaQueryWrapper<RoleRelationDomain> tenantWrapper = Wrappers.lambdaQuery();
        tenantWrapper.eq(RoleRelationDomain::getRelationId, tenantId);
        tenantWrapper.eq(RoleRelationDomain::getType, RoleRelationEnum.TYPE_TENANT.getKey());
        tenantWrapper.eq(RoleRelationDomain::getStatus, StatusEnum.DEFAULT.getKey());
        List<RoleRelationDomain> tenantMenuList = roleRelationMapper.selectList(tenantWrapper);

        List<String> roleIdList = new ArrayList<>();
        roleIdList.addAll(userMenuList.stream().map(RoleRelationDomain::getRoleId).toList());
        roleIdList.addAll(tenantMenuList.stream().map(RoleRelationDomain::getRoleId).toList());
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Result.fail("该用户未分配角色权限，请联系管理员");
        }

        LambdaQueryWrapper<RoleMenuDomain> roleMenuWrapper = Wrappers.lambdaQuery();
        roleMenuWrapper.in(RoleMenuDomain::getRoleId, roleIdList);
        roleMenuWrapper.eq(RoleMenuDomain::getStatus, StatusEnum.DEFAULT.getKey());
        List<RoleMenuDomain> roleMenuList = roleMenuMapper.selectList(roleMenuWrapper);

        LambdaQueryWrapper<MenuDomain> menuWrapper = Wrappers.lambdaQuery();
        menuWrapper.in(MenuDomain::getId, roleMenuList.stream().map(RoleMenuDomain::getMenuId).toList());
        menuWrapper.eq(MenuDomain::getStatus, StatusEnum.DEFAULT.getKey());
        List<MenuDomain> menuList = getBaseMapper().selectList(menuWrapper);

        return Result.success(ObjectUtils.listToTree(ObjectUtils.copyObject(menuList, MenuListTreeResult.class), "-1"));
    }
}
