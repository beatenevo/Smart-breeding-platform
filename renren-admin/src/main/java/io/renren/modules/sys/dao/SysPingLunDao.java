/**
 * Copyright (c)   All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.entity.SysPinglunEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单管理
 * 
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysPingLunDao extends BaseDao<SysPinglunEntity> {

	SysPinglunEntity getById(@Param("id") Long id);

	/**
	 * 查询所有菜单列表
	 *
	 * @param menuType 菜单类型
	 */
	List<SysPinglunEntity> getMenuList(@Param("menuType") Integer menuType);

	/**
	 * 查询用户菜单列表
	 *
	 * @param userId 用户ＩＤ
	 * @param menuType 菜单类型
	 */
	List<SysPinglunEntity> getUserMenuList(@Param("userId") Long userId, @Param("menuType") Integer menuType);

	/**
	 * 查询用户权限列表
	 * @param userId  用户ID
	 */
	List<String> getUserPermissionsList(Long userId);

	/**
	 * 查询所有权限列表
	 */
	List<String> getPermissionsList();

	/**
	 * 根据父菜单，查询子菜单
	 * @param pid  父菜单ID
	 */
	List<SysPinglunEntity> getListPid(Long pid);

}
