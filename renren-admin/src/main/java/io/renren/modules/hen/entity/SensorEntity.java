package io.renren.modules.hen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Data
@TableName("sensor")
public class SensorEntity {

    /**
     * 
     */
	private Long id;
    /**
     * 
     */
	private String type;
    /**
     * 
     */
	private Long henId;
    /**
     * 安装位置
     */
	private String weizhi;
    /**
     * 
     */
	private Date createTime;
}