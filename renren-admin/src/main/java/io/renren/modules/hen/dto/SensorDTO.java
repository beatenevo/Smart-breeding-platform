package io.renren.modules.hen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Data
@ApiModel(value = "")
public class SensorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "")
	private String type;

	@ApiModelProperty(value = "")
	private Long henId;

	@ApiModelProperty(value = "安装位置")
	private String weizhi;

	@ApiModelProperty(value = "")
	private Date createTime;


}