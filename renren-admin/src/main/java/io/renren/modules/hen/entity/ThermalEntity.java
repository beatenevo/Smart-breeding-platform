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
@TableName("thermal")
public class ThermalEntity {

    /**
     * 
     */
	private Long id;
    /**
     * 
     */
	private Date time;
    /**
     * 
     */
	private Integer wendu;
    /**
     * 
     */
	private Integer type;
    /**
     * 
     */
	private Date createTime;
}