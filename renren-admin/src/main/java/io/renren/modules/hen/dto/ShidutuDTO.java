package io.renren.modules.hen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Data
@ApiModel(value = "")
public class ShidutuDTO implements Serializable {
	List<Integer> zuida ;
	List<Integer> zuidi ;
	List<Integer> pingjun;


}