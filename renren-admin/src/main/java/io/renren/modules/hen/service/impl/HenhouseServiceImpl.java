package io.renren.modules.hen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hutool.core.util.StrUtil;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.hen.dao.HenhouseDao;
import io.renren.modules.hen.dto.HenhouseDTO;
import io.renren.modules.hen.entity.HenhouseEntity;
import io.renren.modules.hen.service.HenhouseService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Service
public class HenhouseServiceImpl extends CrudServiceImpl<HenhouseDao, HenhouseEntity, HenhouseDTO> implements HenhouseService {

    @Override
    public QueryWrapper<HenhouseEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<HenhouseEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}