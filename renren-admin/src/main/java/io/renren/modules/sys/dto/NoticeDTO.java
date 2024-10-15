package io.renren.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-10
 */
@Data
@ApiModel(value = "")
public class NoticeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Integer number;

	@ApiModelProperty(value = "")
	private String enterprise;

	@ApiModelProperty(value = "")
	private String company;

	@ApiModelProperty(value = "")
	private String details;

	@ApiModelProperty(value = "")
	private String time;

	@ApiModelProperty(value = "")
	private BigDecimal salary;

	@ApiModelProperty(value = "")
	private String state;


}