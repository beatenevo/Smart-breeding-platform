package io.renren.modules.hen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Data
@TableName("humidity")
public class HumidityEntity {

    /**
     * 
     */
	private Long id;
    /**
     * 
     */
	private String time;
    /**
     * 
     */
	private Integer shidu;
    /**
     * 
     */
	private Date createTime;

    private String type;
}