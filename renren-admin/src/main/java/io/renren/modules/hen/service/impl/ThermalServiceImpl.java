package io.renren.modules.hen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hutool.core.util.StrUtil;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.hen.dao.ThermalDao;
import io.renren.modules.hen.dto.ThermalDTO;
import io.renren.modules.hen.entity.ThermalEntity;
import io.renren.modules.hen.service.ThermalService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Service
public class ThermalServiceImpl extends CrudServiceImpl<ThermalDao, ThermalEntity, ThermalDTO> implements ThermalService {

    @Override
    public QueryWrapper<ThermalEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ThermalEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}