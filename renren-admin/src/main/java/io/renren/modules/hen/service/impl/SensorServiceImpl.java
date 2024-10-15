package io.renren.modules.hen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hutool.core.util.StrUtil;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.hen.dao.SensorDao;
import io.renren.modules.hen.dto.SensorDTO;
import io.renren.modules.hen.entity.SensorEntity;
import io.renren.modules.hen.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Service
public class SensorServiceImpl extends CrudServiceImpl<SensorDao, SensorEntity, SensorDTO> implements SensorService {

    @Override
    public QueryWrapper<SensorEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SensorEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}