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
public class MessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
	private long id;
	@ApiModelProperty(value = "留言ID")
	private Integer messageid;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "内容")
	private String content;

	@ApiModelProperty(value = "楼主")
	private String writer;


}