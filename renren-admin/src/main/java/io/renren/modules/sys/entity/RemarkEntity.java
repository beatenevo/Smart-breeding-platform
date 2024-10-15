package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-10
 */
@Data
@TableName("remark")
public class RemarkEntity {

    /**
     * 
     */
	private Integer id;
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
	private String companyadmin;
    /**
     * 
     */
	private String detail;
}