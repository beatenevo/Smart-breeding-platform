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
@TableName("notice")
public class NoticeEntity {

    /**
     * 
     */
	private Integer number;
    /**
     * 
     */
	private String enterprise;
    /**
     * 
     */
	private String company;
    /**
     * 
     */
	private String details;
    /**
     * 
     */
	private String time;
    /**
     * 
     */
	private BigDecimal salary;
    /**
     * 
     */
	private String state;
}