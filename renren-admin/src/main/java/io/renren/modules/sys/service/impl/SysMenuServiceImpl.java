/**
 * Copyright (c)   All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.service.impl;

import io.renren.common.constant.Constant;
import io.renren.common.exception.ErrorCode;
import io.renren.common.exception.RenException;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.common.utils.ConvertUtils;
import io.renren.common.utils.TreeUtils;
import io.renren.modules.security.user.UserDetail;
import io.renren.modules.sys.dao.SysMenuDao;
import io.renren.modules.sys.dto.SysMenuDTO;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.enums.SuperAdminEnum;
import io.renren.modules.sys.service.SysMenuService;
import io.renren.modules.sys.service.SysRoleMenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
    private final SysRoleMenuService sysRoleMenuService;

    @Override
    public SysMenuDTO get(Long id) {
        SysMenuEntity entity = baseDao.getById(id);

        SysMenuDTO dto = ConvertUtils.sourceToTarget(entity, SysMenuDTO.class);

        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysMenuDTO dto) {
        SysMenuEntity entity = ConvertUtils.sourceToTarget(dto, SysMenuEntity.class);

        //保存菜单
        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysMenuDTO dto) {
        SysMenuEntity entity = ConvertUtils.sourceToTarget(dto, SysMenuEntity.class);

        //上级菜单不能为自身
        if (entity.getId().equals(entity.getPid())) {
            throw new RenException(ErrorCode.SUPERIOR_MENU_ERROR);
        }

        //更新菜单
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        //删除菜单
        deleteById(id);

        //删除角色菜单关系
        sysRoleMenuService.deleteByMenuId(id);
    }

    @Override
    public List<SysMenuDTO> getAllMenuList(Integer menuType) {
        List<SysMenuEntity> menuList = baseDao.getMenuList(menuType);

        List<SysMenuDTO> dtoList = ConvertUtils.sourceToTarget(menuList, SysMenuDTO.class);

        return TreeUtils.build(dtoList, Constant.MENU_ROOT);
    }

    @Override
    public List<SysMenuDTO> getUserMenuList(UserDetail user, Integer menuType) {
        List<SysMenuEntity> menuList;

        //系统管理员，拥有最高权限
        if (user.getSuperAdmin() == SuperAdminEnum.YES.value()) {
            menuList = baseDao.getMenuList(menuType);
        } else {
            menuList = baseDao.getUserMenuList(user.getId(), menuType);
        }

        List<SysMenuDTO> dtoList = ConvertUtils.sourceToTarget(menuList, SysMenuDTO.class);

        return TreeUtils.build(dtoList);
    }

    @Override
    public List<SysMenuDTO> getListPid(Long pid) {
        List<SysMenuEntity> menuList = baseDao.getListPid(pid);

        return ConvertUtils.sourceToTarget(menuList, SysMenuDTO.class);
    }

}