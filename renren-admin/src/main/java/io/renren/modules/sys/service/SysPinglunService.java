/**
 * Copyright (c)   All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.service;

import io.renren.common.service.BaseService;
import io.renren.modules.security.user.UserDetail;
import io.renren.modules.sys.dto.SysMenuDTO;
import io.renren.modules.sys.dto.SysPingLunDTO;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.entity.SysPinglunEntity;

import java.util.List;


/**
 * 菜单管理
 * 
 * @author Mark sunlightcs@gmail.com
 */
public interface SysPinglunService extends BaseService<SysPinglunEntity> {

	SysPingLunDTO get(Long id);

	void save(SysPingLunDTO dto);

	void update(SysPingLunDTO dto);

	void delete(Long id);

	/**
	 * 菜单列表
	 *
	 * @param menuType 菜单类型
	 */
	List<SysPingLunDTO> getAllMenuList(Integer menuType);

	/**
	 * 用户菜单列表
	 *
	 * @param user  用户
	 * @param menuType 菜单类型
	 */
	List<SysPingLunDTO> getUserMenuList(UserDetail user, Integer menuType);

	/**
	 * 根据父菜单，查询子菜单
	 * @param pid  父菜单ID
	 */
	List<SysPingLunDTO> getListPid(Long pid);
}
