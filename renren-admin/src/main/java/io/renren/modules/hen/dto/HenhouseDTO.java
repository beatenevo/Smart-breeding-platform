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
public class HenhouseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "序号")
	private Long id;

	@ApiModelProperty(value = "鸡舍名称")
	private String name;

	@ApiModelProperty(value = "")
	private String weizhi;

	@ApiModelProperty(value = "")
	private String mianji;

	@ApiModelProperty(value = "数量")
	private String number;


}