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
public class CompanyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "")
	private Integer enterpriseid;

	@ApiModelProperty(value = "")
	private String enterprisename;

	@ApiModelProperty(value = "")
	private String name;

	@ApiModelProperty(value = "")
	private Integer type;

	@ApiModelProperty(value = "")
	private Integer available;

	@ApiModelProperty(value = "")
	private String telephone;

	@ApiModelProperty(value = "")
	private BigDecimal salary;

	@ApiModelProperty(value = "")
	private String worktime;


}