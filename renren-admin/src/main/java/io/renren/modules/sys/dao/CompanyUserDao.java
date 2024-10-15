package io.renren.modules.sys.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.dao.BaseDao;
import io.renren.modules.sys.dto.CompanyUserDTO;
import io.renren.modules.sys.entity.CompanyUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-10
 */
@Mapper
public interface CompanyUserDao extends BaseDao<CompanyUserEntity> {
    List<CompanyUserDTO> list(IPage<CompanyUserEntity> page, @Param("params") Map<String, Object> params);
}