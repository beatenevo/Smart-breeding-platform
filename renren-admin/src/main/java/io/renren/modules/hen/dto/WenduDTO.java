package io.renren.modules.hen.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Data
@ApiModel(value = "")
public class WenduDTO implements Serializable {
	List<Integer> wendu ;
	List<Date> time ;


}