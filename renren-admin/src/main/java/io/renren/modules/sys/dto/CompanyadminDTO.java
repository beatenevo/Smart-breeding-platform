package io.renren.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-10
 */
@Data
@ApiModel(value = "")
public class CompanyadminDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "")
	private String username;

	@ApiModelProperty(value = "")
	private String password;

	@ApiModelProperty(value = "")
	private String name;

	@ApiModelProperty(value = "")
	private String gender;

	@ApiModelProperty(value = "")
	private String telephone;


}