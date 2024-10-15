package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-10
 */
@Data
@TableName("company")
public class CompanyEntity {

    /**
     * 
     */
	private Integer id;
    /**
     * 
     */
	private Integer enterpriseid;
    /**
     * 
     */
	private String enterprisename;
    /**
     * 
     */
	private String name;
    /**
     * 
     */
	private Integer type;
    /**
     * 
     */
	private Integer available;
    /**
     * 
     */
	private String telephone;
    /**
     * 
     */
	private BigDecimal salary;
    /**
     * 
     */
	private String worktime;
}