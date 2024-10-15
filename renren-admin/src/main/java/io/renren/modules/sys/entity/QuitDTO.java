package io.renren.modules.sys.entity;

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
public class QuitDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "")
	private Integer companyid;

	@ApiModelProperty(value = "")
	private Integer studentid;

	@ApiModelProperty(value = "")
	private String quittime;

	@ApiModelProperty(value = "")
	private String quitreason;

	@ApiModelProperty(value = "")
	private String companyname;


}