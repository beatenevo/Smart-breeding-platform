package io.renren.modules.hen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hutool.core.util.StrUtil;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.hen.dao.HumidityDao;
import io.renren.modules.hen.dto.HumidityDTO;
import io.renren.modules.hen.entity.HumidityEntity;
import io.renren.modules.hen.service.HumidityService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Service
public class HumidityServiceImpl extends CrudServiceImpl<HumidityDao, HumidityEntity, HumidityDTO> implements HumidityService {

    @Override
    public QueryWrapper<HumidityEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<HumidityEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}